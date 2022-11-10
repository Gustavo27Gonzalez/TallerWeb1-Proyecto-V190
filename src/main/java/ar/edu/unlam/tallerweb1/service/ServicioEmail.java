package ar.edu.unlam.tallerweb1.service;

import org.simplejavamail.api.mailer.Mailer;

import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;

public interface ServicioEmail {
	
	public Mailer getmailer();
	void sendMailRecoveryPassword(String email);
}
