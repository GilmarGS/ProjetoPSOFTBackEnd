package ajude.psoft.controladores;

import java.util.Optional;

import javax.servlet.ServletException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ajude.psoft.entidades.Usuario;
import ajude.psoft.servicos.EmailService;
import ajude.psoft.servicos.JWTService;
import ajude.psoft.servicos.UsuariosService;

@RestController
public class UsuariosController {
	
	private EmailService emailService;
	private UsuariosService usuariosService;
	private JWTService jwtService;

	public UsuariosController(UsuariosService usuariosService, JWTService jwtService, EmailService emailService) {
		super();
		this.usuariosService = usuariosService;
		this.jwtService = jwtService;
		this.emailService = emailService;
	}
	
	@CrossOrigin
	@PostMapping("api/usuarios")
	@ResponseBody
	public ResponseEntity<Usuario> adicionaUsuario(@RequestBody Usuario usuario) throws ServletException{
		if(usuario.getEmail() == null || usuario.getEmail().equals("")) {
			throw new NullPointerException("Email nao pode ser vazio!");
		}
		
		if(existeUsuario(usuario)) {
			throw new ServletException("Usuario ja esta cadastrado!");
		}
		//emailService.enviaEmailBoasVindas(usuario.getEmail());
		return new ResponseEntity<Usuario>(usuariosService.adicionaUsuario(usuario), HttpStatus.CREATED);
		
	}
	
	@CrossOrigin
	@GetMapping("/auth/usuarios/{email}")
	public ResponseEntity<Usuario> adicionaUsuario(@PathVariable String email) {
		Optional<Usuario> usuario = this.usuariosService.getUsuario(email);
		if (usuario.isPresent())
			return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);

		return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
	}
	private boolean existeUsuario(Usuario usuario){
		Optional<Usuario> authUsuario = usuariosService.getUsuario(usuario.getEmail());
		return authUsuario.isPresent();
	}
}
