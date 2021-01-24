import java.util.Properties;

import org.junit.Test;

public class AppTest {
	
	@Test
	public void testEmail(){
	
		//configuração do servidor de email
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");//autorização
		properties.put("mail.smtp.starttls", "true");//atenticação
		properties.put("mail.smtp.host", "smtp.gmail.com");//servidor
		properties.put("mail.smtp.port", "465");//porta
		properties.put("mail.smtp.socketFactory.port", "465");//porta utilizada pelo socket
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");//classe socket para conexão SMTP
		
		
	}

}
