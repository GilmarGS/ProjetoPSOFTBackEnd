package ajude.psoft.servicos;

import org.springframework.stereotype.Service;

import ajude.psoft.entidades.Comentario;
import ajude.psoft.repositories.ComentariosRepository;

@Service
public class ComentariosService {
	private ComentariosRepository<Comentario, Long> comentariosRepository;
	
	public ComentariosService(ComentariosRepository<Comentario, Long> comentariosRepository) {
		this.comentariosRepository = comentariosRepository;
	}
	
	public Comentario adicionaComentario(Comentario comentario) {
		return comentariosRepository.save(comentario);
	}
	
}
