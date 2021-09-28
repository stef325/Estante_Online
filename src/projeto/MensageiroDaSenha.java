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

public class MensageiroDaSenha {
	public static void recuperarSenha(String email,CentralDeInformacoes c, Persistencia p) {
		String  senha = "fibro2020";
		String emailRemetente = "filipeprojeto0@gmail.com";
		
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
		String senhaTemporaria = null;
		String nome = null;
		for(int i = 0; i < c.getTodosAsContas().size(); i++) {
			if(c.getTodosAsContas().get(i).getEmail().equals(email))
				senhaTemporaria = senhaTemporaria();
				nome = c.getTodosAsContas().get(i).getNome();
				c.getTodosAsContas().get(i).setSenha(senhaTemporaria);
				p.salvarCentral(c);
		}
		try {
			Message msg = new MimeMessage(session);
			  msg.setFrom(new InternetAddress(emailRemetente));
			  msg.addRecipient(Message.RecipientType.TO,
			                   new InternetAddress(email));
			  msg.setSubject("Recuperação de senha do Usuario: "+nome);
			  msg.setText("Essa é a sua senha temporaria: "+senhaTemporaria);
			  Transport.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	public static String senhaTemporaria() {
		int numero = (int) (00000+(Math.random()*100001));
		return "senhatemporaria"+numero;
	}
}
