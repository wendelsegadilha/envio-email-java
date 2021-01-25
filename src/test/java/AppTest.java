import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

public class AppTest {

	@Test
	public void testEmail() {

		try {

			// configuração do servidor de email
			Properties properties = new Properties();
			properties.put("mail.smtp.ssl.trust", "*");//autorização ssl
			properties.put("mail.smtp.auth", "true");// autorização
			properties.put("mail.smtp.starttls", "true");// atenticação
			properties.put("mail.smtp.host", "smtp.gmail.com");// servidor
			properties.put("mail.smtp.port", "465");// porta
			properties.put("mail.smtp.socketFactory.port", "465");// porta utilizada pelo socket
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");// classe socket para
																								// conexão SMTP

			// conexão com servidor Gmail
			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("cursojavawebavancado2021@gmail.com", "brasil@2020");
				}
			});
			
			//enviando o e-mail
			Address[] toUsers = InternetAddress.parse("wendelsegadilha99@gmail.com, wendelsegadilha@outlook.com, venes.lopes@gmail.com");
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("cursojavawebavancado2021@gmail.com", "Dev. Java - Wendel Segadilha")); //emissor
			message.addRecipients(Message.RecipientType.TO, toUsers);//receptores
			message.setSubject("Urgente! Chegou o e-mail enviado com Java do Curso Java Avançado");//assunto
			message.setText("Olá meu nome é Wendel Segadilha e eu sou um programador Java.");//messagem - corpo do e-mail
			Transport.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
