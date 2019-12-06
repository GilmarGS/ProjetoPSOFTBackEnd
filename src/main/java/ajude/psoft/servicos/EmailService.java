package ajude.psoft.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void enviaEmailBoasVindas(String email) {
		String emailRemetente = "ajude.ufcg@gmail.com";
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(emailRemetente);
		simpleMailMessage.setReplyTo(emailRemetente);
		simpleMailMessage.setSubject("Ola, seja bem vindo ao AJuDe!");
		simpleMailMessage.setText("link do site");
		simpleMailMessage.setTo(email);
		javaMailSender.send(simpleMailMessage);
	}
}
