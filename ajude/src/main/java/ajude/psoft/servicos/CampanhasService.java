package ajude.psoft.servicos;

import org.springframework.stereotype.Service;

import ajude.psoft.entidades.Campanha;
import ajude.psoft.entidades.Usuario;
import ajude.psoft.repositories.CamapanhasRepository;

@Service
public class CampanhasService {
	private CamapanhasRepository<Campanha, Long> camapanhasRepository;
	
	public CampanhasService(CamapanhasRepository<Campanha, Long> camapanhasRepository) {
		this.camapanhasRepository = camapanhasRepository;
	}
	
	public Campanha adicionaCampanha(Campanha campanha) {
		
		return this.camapanhasRepository.save(campanha);
	}
}
