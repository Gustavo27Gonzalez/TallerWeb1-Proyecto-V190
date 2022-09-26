package ar.edu.unlam.tallerweb1.repository;

import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {
	
	Usuario buscarUsuario(String email, String password);
	void guardar(Usuario usuario);
    Usuario buscar(String email);
	void modificar(Usuario usuario);
	void guardarNuevoUsuario(String email, String password);
}
