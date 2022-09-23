package ar.edu.unlam.tallerweb1.service;

import ar.edu.unlam.tallerweb1.models.UsuarioDos;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioLogin {

	UsuarioDos consultarUsuario(String email, String password);
}
