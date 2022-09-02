package ar.edu.unlam.tallerweb1.service;

import ar.edu.unlam.tallerweb1.models.Usuario;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioLogin {

	Usuario consultarUsuario(String email, String password);
}
