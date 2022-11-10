package ar.edu.unlam.tallerweb1.service;

import java.util.List;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosCompra;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosRegistro;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;

public interface ServicioUsuario {

    Usuario registrar(DatosRegistro datosRegistro);
    Usuario buscarPorId(Long id);
    List<Usuario> listarUsuarios();
    Boolean comprar(DatosCompra datosCompra);
	Usuario buscarPorEmail(String email);
	void enviarMailRecuperacionContraseña(String email);
}