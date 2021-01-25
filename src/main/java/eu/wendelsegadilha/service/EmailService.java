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

	public void enviarEmail(Email email) throws Exception {

		// configuração do servidor de email
		Properties properties = new Properties();
		properties.put("mail.smtp.ssl.trust", "*");// autorização ssl
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
				return new PasswordAuthentication(email.getEmail(), email.getSenha());
			}
		});

		// enviando o e-mail
		Address[] toUsers = InternetAddress.parse(email.getDestinatario());
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(email.getEmail(), email.getRemetente())); // emissor
		message.addRecipients(Message.RecipientType.TO, toUsers);// receptores
		message.setSubject(email.getAssunto());// assunto
		// messagem - corpo do e-mail
		message.setText(email.getMensagem());
		Transport.send(message);
		
	}

}
