package ar.edu.unlam.tallerweb1.domain.usuarios;

import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioRegistrarUsuario {

	void registrarUsuario(String email, String password);
}
