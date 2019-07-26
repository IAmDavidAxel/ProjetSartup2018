package domain.mail;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;
import java.util.Properties;

public class MailSender {

	private String mailSystem;
	private String passwordSystem;

	public MailSender(String mailSystem, String passwordSystem) {
		this.mailSystem = mailSystem;
		this.passwordSystem = passwordSystem;
	}

	public void send(String destination , String subject, String body) throws MailSenderException {

		Properties properties = new Properties();

		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.starttls.enable","true");

		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailSystem, passwordSystem);
			}
		});

		try {
			int index = destination.indexOf('@');
			String hostname = destination.substring(index + 1);
			checkMXRecords(hostname);
			MimeMessage message = new MimeMessage(session);
			InternetAddress internetAddress = new InternetAddress(destination);
			internetAddress.validate();
			message.addRecipient(Message.RecipientType.TO, internetAddress);
			message.setSubject(subject);
			message.setText(body);
			Transport.send(message);

		} catch (AuthenticationFailedException e) {
			throw new AuthenticationFailedMailSenderException();
		} catch (NamingException e) {
			throw new MailSenderException();
		} catch (AddressException e) {
			throw new MailSenderException();
		} catch (MessagingException e) {
			throw new MailSenderException();
		} catch (Exception e) {
			throw new MailSenderException();
		}
	}




	public void checkMXRecords(String hostName) throws NamingException {
		Hashtable<String, String> env = new Hashtable<>();
		env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
		DirContext ictx = new InitialDirContext(env);
		Attributes attrs = ictx.getAttributes(hostName, new String[] { "MX" });
		Attribute attr = attrs.get("MX");
		if ((attr == null) || (attr.size() == 0)) {
			attrs = ictx.getAttributes(hostName, new String[] { "A" });
			attr = attrs.get("A");
			if (attr == null)
				throw new NamingException("No match for name '" + hostName + "'");
		}
	}

}


