package ar.edu.unlam.tallerweb1.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosLogin;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.repository.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.service.ServicioLogin;
import exceptions.UsuarioLoginException;

// Implelemtacion del Servicio de usuarios, la anotacion @Service indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.servicios
// para encontrar esta clase.
// La anotacion @Transactional indica que se debe iniciar una transaccion de base de datos ante la invocacion de cada metodo del servicio,
// dicha transaccion esta asociada al transaction manager definido en el archivo spring-servlet.xml y el mismo asociado al session factory definido
// en hibernateCOntext.xml. De esta manera todos los metodos de cualquier dao invocados dentro de un servicio se ejecutan en la misma transaccion
@Service("servicioLogin")
@Transactional
public class ServicioLoginImpl implements ServicioLogin {

	@Autowired
	private RepositorioUsuario repositorioUsuario;

	@Autowired
	public ServicioLoginImpl(RepositorioUsuario repositorioUsuario) {
		this.repositorioUsuario = repositorioUsuario;
	}

	@Override
	public Usuario consultarUsuario(String email) {
		return repositorioUsuario.buscarPorEmail(email);
	}

	@Override
	public Usuario validarUsuario(DatosLogin datosLogin) throws UsuarioLoginException {
		Usuario buscado = this.repositorioUsuario.buscarPorEmail(datosLogin.getEmail());
		
		if (buscado.equals(null)) {
			throw new UsuarioLoginException("El mail: " + datosLogin.getEmail() + " no existe");
		}
		
		if (datosLogin.getEmail().equals(buscado.getEmail())) {
			// valida que lo ingresado sea igual a la contraseña que el usuario buscado
			// tiene guardada
			if (datosLogin.getPassword().equals(buscado.getPassword()))
				return buscado;
			else
				throw new UsuarioLoginException("La contraseña ingresada no es válida");
		}
		return buscado;
	}

	@Override
	public void registrar(String usuario, String clave) {
		if(yaExiste(usuario))
			throw new RuntimeException("usuario existente");

		Usuario nuevoUsuario = new Usuario();
		nuevoUsuario.setEmail(usuario);
		nuevoUsuario.setPassword(clave);
		repositorioUsuario.guardar(nuevoUsuario);
	}

	private boolean yaExiste(String usuario) {
		return repositorioUsuario.buscarPorEmail(usuario) != null;
	}
}
