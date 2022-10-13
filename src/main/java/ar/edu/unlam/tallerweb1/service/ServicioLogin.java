package ar.edu.unlam.tallerweb1.service;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosLogin;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import exceptions.UsuarioLoginException;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioLogin {

	Usuario consultarUsuario(String email);
	Usuario validarUsuario(DatosLogin datosLogin) throws UsuarioLoginException;
}
