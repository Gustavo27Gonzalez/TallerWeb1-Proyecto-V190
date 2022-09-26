package ar.edu.unlam.tallerweb1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.models.usuarios.DatosRegistro;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.repository.RepositorioUsuario;

@Service("servicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

    private RepositorioUsuario repo;
    
    @Autowired
    public ServicioUsuarioImpl(RepositorioUsuario servicioUsuarioDao){
        this.repo = servicioUsuarioDao;
    }

    public Usuario registrar(DatosRegistro datosRegistro){
        
        Usuario nuevoUsuario = new Usuario(datosRegistro);
        repo.guardar(nuevoUsuario);
        return nuevoUsuario;
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return null;
    }

    

    @Override
    public List<Usuario> listarTodos() {
        return null;
    }

	@Override
	public Boolean lasClavesSonDistintas(DatosRegistro datosRegistro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean laClaveTieneLongitudIncorrecta(DatosRegistro datosRegistro) {
		// TODO Auto-generated method stub
		return null;
	}

}