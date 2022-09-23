package ar.edu.unlam.tallerweb1.repository;

import ar.edu.unlam.tallerweb1.models.UsuarioDos;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {
	
	UsuarioDos buscarUsuario(String email, String password);
	void guardar(UsuarioDos usuario);
    UsuarioDos buscar(String email);
	void modificar(UsuarioDos usuario);
}
