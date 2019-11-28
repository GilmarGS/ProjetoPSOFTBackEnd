package ajude.psoft.servicos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajude.psoft.comparadores.ComparadorCampanhaDeadLine;
import ajude.psoft.comparadores.ComparadorCampanhaLikes;
import ajude.psoft.comparadores.ComparadorCampanhaMeta;
import ajude.psoft.entidades.Campanha;
import ajude.psoft.entidades.Comentario;
import ajude.psoft.entidades.Doacao;
import ajude.psoft.entidades.Curtir;
import ajude.psoft.entidades.Usuario;
import ajude.psoft.repositories.CampanhasRepository;

@Service
public class CampanhasService {
	private CampanhasRepository<Campanha, Long> campanhasRepository;
	
	@Autowired
	private ComparadorCampanhaDeadLine cd;
	
	@Autowired
	private ComparadorCampanhaLikes cl;
	
	@Autowired
	private ComparadorCampanhaMeta cm;
	
	@Autowired
	private ComentariosService comentariosService;
	
	@Autowired
	private DoacoesService doacoesService;
	@Autowired
	LikesService likesService;
	
	public CampanhasService(CampanhasRepository<Campanha, Long> campanhasRepository) {
		this.campanhasRepository = campanhasRepository;		
	}
	
	public Campanha adicionaCampanha(Campanha campanha) {
		return this.campanhasRepository.save(campanha);
	}
	
	public List<Campanha> recuperaCampanhas(String nomeCurto){
		List<Campanha> listaCampanha = campanhasRepository.findAll();
		List<Campanha> resultado = new ArrayList<>();
		
		String pesquisa = retiraAcentos(nomeCurto);
		
		for(Campanha c : listaCampanha) {
			String atual = retiraAcentos(c.getNomeCurto());
			if(atual.toUpperCase().contains(pesquisa.toUpperCase())) {
				resultado.add(c);
			}
		}
				
		return resultado;
	}
	public Campanha recuperaCampanhaIdUrl(String idUrl) {		
		return recuperaIdUrl(idUrl);
	}
	
	private Campanha recuperaIdUrl(String idUrl){
		List<Campanha> campanhaUrl = campanhasRepository.findAll();
		Campanha campanha = null;
		for(Campanha c : campanhaUrl){
			if(c.getIdURL().equals(idUrl)){
				campanha = c;
			}
		}
		return campanha;
	}
	
	private String retiraAcentos(String input){ 
		return input.replaceAll("á|à|â|ã","a") .replaceAll("é|ê","e") .replace("í|î","i") .replace("ó|ô|õ","o") .replace("ú","u") .replace("ç", "c"); 
		
	}
	public Boolean confereIdURL(Campanha campanha) {
		List<Campanha> campanhaURL = campanhasRepository.findAll();
		boolean retorno = false;
		for(Campanha c : campanhaURL) {
			if(c.getIdURL().equals(campanha.getIdURL())) {
				retorno = true;
			}
		}
		return retorno;
	}

	private Campanha recuperaCampanhaId(long id) throws ServletException {
		if(!this.campanhasRepository.existsById(id)) {
			throw new ServletException("Campanha nao existe!");
		}
		return this.campanhasRepository.findById(id).get();
	}
	
	public Campanha adicionaComentario(long id, Comentario comentario) throws ServletException {
		comentariosService.adicionaComentario(comentario);		
		Campanha campanha = recuperaCampanhaId(id);
		comentario.setCampanha(campanha);
		campanha.getComentarios().add(comentario);
		campanhasRepository.save(campanha);
		
		return campanha;
		
	}
	
	public Campanha apagaComentario(long Id, long comentarioId, Usuario usuario) throws ServletException {
		String donoComentario = comentariosService.pegaComentarioId(comentarioId);
		
		if(!recuperaEmailUsuario(usuario).equals(donoComentario)) {
			throw new ServletException("Voce nao tem permissao para apagar esse comentario!");
		}
		
		Campanha campanha = recuperaCampanhaId(Id);
		campanha.getComentarios().remove(comentariosService.achaId(comentarioId));
		comentariosService.apagaPeloId(comentarioId);
		campanhasRepository.save(campanha);
		
		return campanhasRepository.findById(Id).get();
	}
	
	public Campanha adicionaLike(long id, Usuario usuario) throws ServletException {
		Campanha campanha = recuperaCampanhaId(id);
		Usuario dono = usuario;
		Curtir like = new Curtir(dono);
		if(verificaLike(campanha, dono)) {
			Set<Curtir> likes = campanha.getLikes();
			for(Curtir l : likes) {
				if(l.getUsuario().equals(dono)) {
					campanha.getLikes().remove(l);
					likesService.apagaLike(l.getId());
					campanhasRepository.save(campanha);
				}
			}
			
		}else {
			likesService.adicionaLike(like);
			campanha.getLikes().add(like);
			campanhasRepository.save(campanha);
		}
		return campanha;
	}
	
	public Campanha adicionaDoacao(long id, Doacao doacao, double arrecadacao) throws ServletException {
		doacoesService.adicionaDoacao(doacao);		
		Campanha campanha = recuperaCampanhaId(id);
		campanha.setValorArrecadado(arrecadacao);
		campanha.getDoacoes().add(doacao);
		campanhasRepository.save(campanha);
		
		return campanha;
		
	}
	public List<Campanha> ordenaCampanhaCronologia(){		
		List<Campanha> campanhas = campanhasRepository.findAll();
		Collections.sort(campanhas, cd);
		return campanhas;
	}
	
	public List<Campanha> ordenaCampanhaLikes(){		
		List<Campanha> campanhas = campanhasRepository.findAll();
		Collections.sort(campanhas, cl);
		return campanhas;
	}
	
	public List<Campanha> ordenaCampanhaMeta(){		
		List<Campanha> campanhas = campanhasRepository.findAll();
		Collections.sort(campanhas, cm);
		return campanhas;
	}
	
	private String recuperaEmailUsuario(Usuario usuario) {
		String emailUsuario = usuario.getEmail();
		return emailUsuario;
	}

	private boolean verificaLike(Campanha campanha, Usuario usuario) throws ServletException {
		boolean retorno = false;
		Set<Curtir> likes = campanha.getLikes();
		for(Curtir l: likes) {
			if(l.getUsuario().equals(usuario)) {
				retorno = true;
			}
		}
		return retorno;
	}
}

