import org.junit.Test;

import eu.wendelsegadilha.model.Email;
import eu.wendelsegadilha.service.EmailService;

public class AppTest {

	@Test
	public void testEmail() {

		Email email = new Email();
		email.setEmail("seuemailaqui@gmail.com");
		email.setSenha("suasenhaaqui");
		email.setRemetente("WS Desenvolvimento de Softwares");
		/*Enviar para mais de um destinatário é necessário passar os emails deparados por vírgula*/
		//email.setDestinatario("destinatario01aqui@gmail.com, destinatario02aqui@gmail.com, ... ");
		email.setDestinatario("destinatarioaqui@gmail.com");
		email.setAssunto("Venha fazer parte da nossa equipe de programadores");
		email.setMensagem("Olá, <b>Programador Java</b> seja bem vindo a nossa equipe.<br/>Estamos felizes por você!"
				+ "<br/><a href=\"https://www.bol.uol.com.br/\" target=\"_blank\">Acesse aqui!</a>");
		
		EmailService emailService = new EmailService();
		try {
			emailService.enviarEmail(email, true);
			System.out.println("E-mail enviado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
