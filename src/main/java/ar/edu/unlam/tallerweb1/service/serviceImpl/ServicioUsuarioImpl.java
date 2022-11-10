package ar.edu.unlam.tallerweb1.service.serviceImpl;

import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosCompra;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosRegistro;
import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.repository.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.service.ServicioUsuario;

@Service("servicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

	@Autowired
    RepositorioUsuario repositorioUsuario;
    
    @Autowired
    public ServicioUsuarioImpl(RepositorioUsuario repositorioUsuario){
        this.repositorioUsuario = repositorioUsuario;
    }

    @Override
    public Usuario registrar(DatosRegistro datosRegistro){
        Usuario nuevoUsuario = new Usuario(datosRegistro);
        repositorioUsuario.guardar(nuevoUsuario);
        return nuevoUsuario;
    }
    
    @Override
	public Boolean comprar(DatosCompra datosCompra) {
    	Boolean flag = false;
		Compra compra = new Compra(datosCompra);
		try {
			repositorioUsuario.guardarCompra(compra);
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

    @Override
    public Usuario buscarPorId(Long id) {
        return null;
    }

	@Override
	public List<Usuario> listarUsuarios() {
		return this.repositorioUsuario.listarUsuarios();
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		return this.repositorioUsuario.buscarPorEmail(email);
	}

	@Override
	public void enviarMailRecuperacionContraseña(String email) {
		
	}

	

   

}