import org.junit.Test;

import eu.wendelsegadilha.model.Email;
import eu.wendelsegadilha.service.EmailService;

public class AppTest {

	@Test
	public void testEmail() {

		Email email = new Email();
		email.setEmail("cursojavawebavancado2021@gmail.com");
		email.setSenha("brasil@2020");
		email.setRemetente("WS Desenvolvimento de Softwares");
		email.setDestinatario("wendelsegadilha99@gmail.com");
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
