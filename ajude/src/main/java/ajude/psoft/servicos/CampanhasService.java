package ajude.psoft.servicos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ajude.psoft.entidades.Campanha;
import ajude.psoft.repositories.CamapanhasRepository;

@Service
public class CampanhasService {
	private CamapanhasRepository<Campanha, Long> campanhasRepository;
	
	public CampanhasService(CamapanhasRepository<Campanha, Long> campanhasRepository) {
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
			System.out.println(pesquisa.toUpperCase().contains(atual.toUpperCase()));
			System.out.println(pesquisa);
			System.out.println(atual);
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


}
