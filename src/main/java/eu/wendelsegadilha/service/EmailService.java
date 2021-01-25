package eu.wendelsegadilha.service;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import eu.wendelsegadilha.model.Email;

public class EmailService {

	public void enviarEmail(Email email, boolean textIsHtml) throws Exception {

		// configura��o do servidor de email
		Properties properties = new Properties();
		properties.put("mail.smtp.ssl.trust", "*");// autoriza��o ssl
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
				return new PasswordAuthentication(email.getEmail(), email.getSenha());
			}
		});

		// enviando o e-mail
		Address[] toUsers = InternetAddress.parse(email.getDestinatario());
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(email.getEmail(), email.getRemetente())); // emissor
		message.addRecipients(Message.RecipientType.TO, toUsers);// receptores
		message.setSubject(email.getAssunto());// assunto
		
		if(textIsHtml) {
			//e-mail em html
			message.setContent(email.getMensagem(), "text/html; charset=utf-8");
		}else {
			//e-mail em texto puro
			message.setText(email.getMensagem());// messagem - corpo do e-mail			
		}
		
		Transport.send(message);
		
	}

}
