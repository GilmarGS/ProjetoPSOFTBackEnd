package ajude.psoft.servicos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajude.psoft.entidades.Campanha;
import ajude.psoft.entidades.Doacao;
import ajude.psoft.entidades.Perfil;
import ajude.psoft.entidades.Usuario;
import ajude.psoft.repositories.DoacoesRepository;
import ajude.psoft.repositories.CampanhasRepository;
import ajude.psoft.repositories.PerfisRepository;

@Service
public class PerfisService {
	private PerfisRepository<Perfil, Long> perfisRepository;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private CampanhasRepository campanhasRepository;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private DoacoesRepository doacoesRepository;
		
	PerfisService(PerfisRepository<Perfil, Long> perfisRepository){
		this.perfisRepository = perfisRepository;
	}
		
	public Perfil recuperaPerfil(String url) {
		Perfil perfil = pegaUrl(url);
		perfil.setCampanhas(recuperaCampanha(perfil.getUsuario()));
		perfil.setDoacao(recuperaDoacao(perfil.getUsuario()));
			
		return perfil;
	}
		
	public Perfil pegaUrl(String url) {
		for(Perfil p: perfisRepository.findAll()) {
			if(p.getUrlPerfil().equals(url)) {
				return p;
			}
		}
			
			return null;
	}
	
	private Set<Campanha> recuperaCampanha(Usuario usuario){
		Set<Campanha> resultado = new HashSet<Campanha>();
		@SuppressWarnings("unchecked")
		List<Campanha> campanhas = campanhasRepository.findAll();
		for(Campanha c : campanhas) {
			if(c.getDono().equals(usuario)) {
				resultado.add(c);
			}
		}
			
		return resultado;
	}
		
	private Set<Doacao> recuperaDoacao(Usuario usuario){
		Set<Doacao> resultado = new HashSet<Doacao>();
		@SuppressWarnings("unchecked")
		List<Doacao> doacoes = doacoesRepository.findAll();
		for(Doacao d: doacoes) {
			if(d.getDono().equals(usuario)) {
				resultado.add(d);
			}
		}
		
		return resultado;
	}
}