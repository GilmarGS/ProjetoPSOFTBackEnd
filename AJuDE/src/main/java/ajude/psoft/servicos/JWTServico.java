package ajude.psoft.servicos;

import java.util.Date;
import java.util.Optional;

import javax.servlet.ServletException;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import ajude.psoft.entidades.Usuario;
import ajude.psoft.filtros.FiltroToken;

@Service
public class JWTServico{
	private ServicoUsuario servicoUsuario;
	private final String TOKEN_KEY = "login do batman";


	public JWTServico(ServicoUsuario servicoUsuario) {
		super();
		this.servicoUsuario = servicoUsuario;
	}

	public boolean usuarioExiste(String authorizationHeader) throws ServletException {
		String subject = getSujeitoDoToken(authorizationHeader);

		return servicoUsuario.getUsuario(subject).isPresent();
	}
	
	public boolean usuarioTemPermissao(String authorizationHeader, String email) throws ServletException {
		String subject = getSujeitoDoToken(authorizationHeader);

		Optional<Usuario> optUsuario = servicoUsuario.getUsuario(subject);
		return optUsuario.isPresent() && optUsuario.get().getEmail().equals(email);
	}

	private String getSujeitoDoToken(String authorizationHeader) throws ServletException {
		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
			throw new ServletException("Token inexistente ou mal formatado!");
		}

		// Extraindo apenas o token do cabecalho.
		String token = authorizationHeader.substring(FiltroToken.TOKEN_INDEX);

		String subject = null;
		try {
			subject = Jwts.parser().setSigningKey("login do batman").parseClaimsJws(token).getBody().getSubject();
		} catch (SignatureException e) {
			throw new ServletException("Token invalido ou expirado!");
		}
		return subject;
	}

	public String geraToken(String email) {
		return Jwts.builder().setSubject(email)
		.signWith(SignatureAlgorithm.HS512, TOKEN_KEY)
		.setExpiration(new Date(System.currentTimeMillis() + 3 * 60 * 1000)).compact();//3 min
	}
	
	

}