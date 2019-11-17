package ajude.psoft.servicos;

import java.util.Optional;

import javax.servlet.ServletException;

import org.springframework.stereotype.Service;

import ajude.psoft.entidades.Usuario;
import ajude.psoft.repositories.UsuariosRepository;

@Service
public class UsuariosService {
	
	private UsuariosRepository<Usuario, String > usuariosDAO;

	public UsuariosService(UsuariosRepository<Usuario, String> usuariosDAO) {
		super();
		this.usuariosDAO = usuariosDAO;
	}
	
	public Usuario adicionaUsuario(Usuario usuario) {
		return this.usuariosDAO.save(usuario);
	}
	
	public Optional<Usuario> getUsuario(String email) {
		return this.usuariosDAO.findByEmail(email);
	}
	
	public Optional<Usuario> isPresent(String email) {
		return this.usuariosDAO.findById(email);
	}
}
