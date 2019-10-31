package ajude.psoft.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ajude.psoft.entidades.Usuario;
import ajude.psoft.servicos.ServicoUsuario;

@RestController
public class ControladorUsuario {
	private ServicoUsuario servicoUsuario;
	
	public ControladorUsuario(ServicoUsuario servicoUsuario) {
		super();
		this.servicoUsuario = servicoUsuario;
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> adicionaUsuario(@RequestBody Usuario usuario) {
		return new ResponseEntity<Usuario>(servicoUsuario.adicionaUsuario(usuario), HttpStatus.CREATED);
	}
}
