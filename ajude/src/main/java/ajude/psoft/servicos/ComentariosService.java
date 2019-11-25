package ajude.psoft.servicos;

import javax.servlet.ServletException;

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

	public String pegaComentarioId(long comentarioId) {
		Comentario comentarios = comentariosRepository.findById(comentarioId).get();
		return comentarios.getDono().getEmail();
	}

	public Comentario achaId(long id) throws ServletException {
		if (!comentariosRepository.existsById(id)) {
			throw new ServletException("Comentario nao encontrado!");
		}
		
		return comentariosRepository.findById(id).get();
	}

	public void apagaPeloId(long id) throws ServletException {
		if (!comentariosRepository.existsById(id)) {
			throw new ServletException("There is not a comment registered with this id in the system");
		}
		
		comentariosRepository.deleteById(id);
	}
}
