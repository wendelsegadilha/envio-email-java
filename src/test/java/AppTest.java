import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.junit.Test;

public class AppTest {

	@Test
	public void testEmail() {

		try {

			// configura��o do servidor de email
			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true");// autoriza��o
			properties.put("mail.smtp.starttls", "true");// atentica��o
			properties.put("mail.smtp.host", "smtp.gmail.com");// servidor
			properties.put("mail.smtp.port", "465");// porta
			properties.put("mail.smtp.socketFactory.port", "465");// porta utilizada pelo socket
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");// classe socket para
																								// conex�o SMTP

			// conex�o com servidor Gmail
			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("cursojavawebavancado2021@gmail.com", "brasil@2020");
				}
			});
			System.out.println(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
