package ar.edu.unlam.tallerweb1.service.serviceImpl;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.MailerRegularBuilder;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.service.ServicioEmail;

@Service("servicioEmail")
public class ServicioEmailImpl implements ServicioEmail{

	@Override
	public Mailer getmailer() {
		try {
			MailerRegularBuilder mb = MailerBuilder
					.withSMTPServer("smtp.gmail.com", 465, "aguslive7@gmail.com", "Sortea2")
					.withTransportStrategy(TransportStrategy.SMTPS);
			Mailer mailer = mb.buildMailer();
			return mailer;
		} catch (Exception e) {
			throw e;
		}
	}
	
	private Email createEmailRecoveryPassword(String mailUser, String fileName, ByteArrayDataSource bytes, MimeBodyPart pdfBodyPar) {
		Email email = EmailBuilder.startingBlank().from("Sortea2", "aguslive7@gmail.com").to("cliente", "aguslive7@gmail.com")
				.withSubject("Recuperar contraseña").withPlainText("Mail de recuperación")
				.withAttachment(fileName, bytes).buildEmail();
		return email;
	}

	@Override
	public void sendMailRecoveryPassword(String email) {
		try {
			Session session = Session.getDefaultInstance(createProperies());
			MimeMessage msg = new MimeMessage(session);
			msg.setSubject("Recuperar contraseña");
			msg.setFrom(new InternetAddress("aguslive7@gmail.com"));
			msg.addRecipient(RecipientType.TO, new InternetAddress("aguslive7@gmail.com"));
			MimeBodyPart pdfBodyPart = new MimeBodyPart();
			pdfBodyPart.setText("Se le adjunta un código para que ingrese a cambiar contraseña");
			MimeMultipart mimeMultipart = new MimeMultipart();
			mimeMultipart.addBodyPart(pdfBodyPart);
			msg.setContent(mimeMultipart);
			Transport.send(msg, "aguslive7@gmail.com", "Agusromero1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Properties createProperies() {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", 587);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.user", "aguslive7@gmail.com");
		properties.put("mail.password", "");
		return properties;
	}
}
		

