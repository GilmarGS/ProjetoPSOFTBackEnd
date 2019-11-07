package ajude.psoft.controladores;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ajude.psoft.entidades.Usuario;
import ajude.psoft.servicos.EmailService;
import ajude.psoft.servicos.JWTService;
import ajude.psoft.servicos.UsuariosService;

@RestController
public class UsuariosController {
	
	private EmailService enviaEmail;
	private UsuariosService usuariosService;
	private JWTService jwtService;

	public UsuariosController(UsuariosService usuariosService, JWTService jwtService) {
		super();
		this.usuariosService = usuariosService;
		this.jwtService = jwtService;
	}

	@PostMapping("/api/usuarios")
	@RequestMapping(value="/singup", method = RequestMethod.POST)
	public ResponseEntity<Usuario> adicionaUsuario(@RequestBody Usuario usuario) {
		enviaEmail.enviaEmailBoasVindas(usuario.getEmail());
		return new ResponseEntity<Usuario>(this.usuariosService.adicionaUsuario(usuario), HttpStatus.OK);
	}

	@GetMapping("/auth/usuarios/{email}")
	public ResponseEntity<Usuario> adicionaUsuario(@PathVariable String email) {
		Optional<Usuario> usuario = this.usuariosService.getUsuario(email);
		if (usuario.isPresent())
			return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);

		return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
	}
}
