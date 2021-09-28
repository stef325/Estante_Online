package projeto;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public abstract class Mensageiro {
	
	
	public static void enviarListaDeLivros(String email, String relatorio) {
		String  senha = "||| SENDER EMAIL PASSWORD |||";
		String emailRemetente = "||| SENDER EMAIL |||";
		
		Properties props = new Properties();
		props.put("mail.smtp.user", emailRemetente); 
		props.put("mail.smtp.host", "smtp.gmail.com"); 
		props.put("mail.smtp.port", "25"); 
		props.put("mail.debug", "true"); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.starttls.enable","true"); 
		props.put("mail.smtp.EnableSSL.enable","true");

		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
		props.setProperty("mail.smtp.socketFactory.fallback", "false");   
		props.setProperty("mail.smtp.port", "465");   
		props.setProperty("mail.smtp.socketFactory.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(emailRemetente,senha);
			}
		});
		session.setDebug(true);
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(emailRemetente));
			Address[] ToUser = InternetAddress.parse(email);
			message.setRecipients(Message.RecipientType.TO, ToUser);
			message.setSubject(relatorio);
			MimeBodyPart mbp1 = new MimeBodyPart();
			mbp1.setText(relatorio);
			MimeBodyPart mbp2 = new MimeBodyPart();
			FileDataSource fds = new FileDataSource(relatorio);
			mbp2.setDataHandler(new DataHandler(fds));
			mbp2.setFileName(fds.getName());
			Multipart mp = new MimeMultipart();
			mp.addBodyPart(mbp1);
			mp.addBodyPart(mbp2);
			message.setContent(mp);
			message.setSentDate(new Date());
			Transport.send(message);
		} catch (MessagingException e) {
			JOptionPane.showMessageDialog(null, "Erro No envio da messagem");
		}
	}
}
