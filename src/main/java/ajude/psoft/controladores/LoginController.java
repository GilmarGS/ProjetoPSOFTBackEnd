package ajude.psoft.controladores;

import java.util.Optional;

import javax.servlet.ServletException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ajude.psoft.entidades.Usuario;
import ajude.psoft.servicos.JWTService;
import ajude.psoft.servicos.UsuariosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "Controller login")
@RestController
@RequestMapping("api/usuarios/auth")

public class LoginController {

	private UsuariosService usuariosService;
	private JWTService jwtService;

	public LoginController(UsuariosService usuariosService, JWTService jwtService) {
		super();
		this.usuariosService = usuariosService;
		this.jwtService = jwtService;
	}

	@ApiOperation(value = "cria um login e associa a um token")
	@CrossOrigin
	@ResponseBody
	@PostMapping("/login")
	public LoginResponse authenticate(@RequestBody Usuario usuario) throws ServletException {

		// Recupera o usuario
		Optional<Usuario> authUsuario = usuariosService.getUsuario(usuario.getEmail());

		// verificacoes
		if (!authUsuario.isPresent()) {
			throw new ServletException("Usuario nao encontrado!");
		}

		verificaSenha(usuario, authUsuario);

		String token = jwtService.geraToken(authUsuario.get().getEmail());

		return new LoginResponse(token);

	}

	private void verificaSenha(Usuario usuario, Optional<Usuario> authUsuario) throws ServletException {
		if (!authUsuario.get().getSenha().equals(usuario.getSenha())) {
			throw new ServletException("Senha invalida!");
		}
	}

	private class LoginResponse {
		public String token;

		public LoginResponse(String token) {
			this.token = token;
		}
	}

}
