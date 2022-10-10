package ar.edu.unlam.tallerweb1.repository;

import java.util.List;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosLogin;
import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {
	Usuario buscarId(Long id);
	Usuario buscarPorEmail(String email);
	void guardar(Usuario usuario);
	void modificar(Usuario usuario);
	List <Usuario> listarUsuarios();
	void guardarCompra(Compra compra);
}
