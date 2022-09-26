package ar.edu.unlam.tallerweb1.service;

import java.util.List;

import ar.edu.unlam.tallerweb1.models.usuarios.DatosRegistro;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;

public interface ServicioUsuario {

    Usuario registrar(DatosRegistro datosRegistro);
    Usuario buscarPorId(Long id);
    Boolean lasClavesSonDistintas(DatosRegistro datosRegistro);
    Boolean laClaveTieneLongitudIncorrecta(DatosRegistro datosRegistro);
    List<Usuario> listarTodos();
}