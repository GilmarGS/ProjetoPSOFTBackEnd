package ajude.psoft.servicos;

import org.springframework.stereotype.Service;

import ajude.psoft.daos.UsuariosRepository;
import ajude.psoft.entidades.Usuario;

@Service
public class ServicoUsuario {
	private UsuariosRepository<Usuario, String> usuariosDAO;
	
	public ServicoUsuario(UsuariosRepository<Usuario, String> usuariosDAO) {
		super();
		this.usuariosDAO = usuariosDAO;
	}
	
	public Usuario adicionaUsuario(Usuario usuario) {
		if(temEmail(usuario)) {
			throw new IllegalArgumentException("Digite um email!");
		}
		if(usuarioExiste(usuario)) {
			throw new IllegalArgumentException("Usuario ja esta cadastrado!");
		}
		return usuariosDAO.save(usuario);
	}

	private boolean temEmail(Usuario usuario) {
		return (usuario.getEmail() == "");
		
	}	
	private boolean usuarioExiste(Usuario usuario) {
		if(usuariosDAO.findById(usuario.getEmail()).equals(null)) {
			return false;
		}
		
		return true;
	}
}
