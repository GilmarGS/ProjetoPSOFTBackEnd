package ajude.psoft.servicos;

import org.springframework.stereotype.Service;

import ajude.psoft.entidades.Curtir;
import ajude.psoft.repositories.LikesRepository;

@Service
public class LikesService {
	private LikesRepository<Curtir, Long> likesRepository;
	
	public LikesService(LikesRepository<Curtir, Long> likesRepository) {
		this.likesRepository = likesRepository;
	}
	
	public Curtir adicionaLike(Curtir like) {
		return this.likesRepository.save(like);
	}

	public void apagaLike(long id) {
		this.likesRepository.deleteById(id);
		
	}
}
