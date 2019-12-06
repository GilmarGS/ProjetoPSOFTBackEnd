package ajude.psoft.servicos;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ajude.psoft.entidades.Usuario;
import ajude.psoft.repositories.UsuariosRepository;

@Service
public class UsuariosService {
	
	private UsuariosRepository<Usuario, String > usuariosRepository;

	public UsuariosService(UsuariosRepository<Usuario, String> usuariosRepository) {
		super();
		this.usuariosRepository = usuariosRepository;
	}
	
	public Usuario adicionaUsuario(Usuario usuario) {
		return this.usuariosRepository.save(usuario);
	}
	
	public Optional<Usuario> getUsuario(String email) {
		return this.usuariosRepository.findByEmail(email);
	}
	
	public Optional<Usuario> isPresent(String email) {
		return this.usuariosRepository.findById(email);
	}
	
	public Usuario findByEmail(String email) {
		return this.usuariosRepository.findByEmail(email).get();
	}
}
