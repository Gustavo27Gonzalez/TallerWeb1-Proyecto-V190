package ar.edu.unlam.tallerweb1.service;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioLogin {

	Usuario consultarUsuario(String email, String password);
}
