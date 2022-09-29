package ar.edu.unlam.tallerweb1.service.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosRegistro;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.repository.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.service.ServicioUsuario;

@Service("servicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

	@Autowired
    RepositorioUsuario repositorioUsuario;
    
    @Autowired
    public ServicioUsuarioImpl(RepositorioUsuario servicioUsuarioDao){
        this.repositorioUsuario = servicioUsuarioDao;
    }

    @Override
    public Usuario registrar(DatosRegistro datosRegistro){
        
        Usuario nuevoUsuario = new Usuario(datosRegistro);
        repositorioUsuario.guardar(nuevoUsuario);
        return nuevoUsuario;
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return null;
    }

	@Override
	public List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

   

}