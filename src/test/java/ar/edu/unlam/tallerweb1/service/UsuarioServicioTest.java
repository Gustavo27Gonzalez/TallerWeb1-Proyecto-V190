package ar.edu.unlam.tallerweb1.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.repository.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.service.serviceImpl.ServicioUsuarioImpl;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

public class UsuarioServicioTest extends SpringTest{
	
	private static final Usuario USUARIONUEVO = new Usuario ("jose@test.com", "1234pass", "Activo");
	private static final Usuario USUARIONUEVO2 = new Usuario ("jose@gmail.com", "1234pass", "Activo");
	private ServicioUsuario servicioUsuario;
	private RepositorioUsuario repositorioUsuario;
	
	
	public void init () {
		this.repositorioUsuario = mock(RepositorioUsuario.class);
		this.servicioUsuario = new ServicioUsuarioImpl(repositorioUsuario);
	}
	
	
	@Test
	public void quieroTestearQueHayaUnUsuarioExistente() {
		givenExisteUnUsuario(USUARIONUEVO, USUARIONUEVO2);
		Usuario usuarioBuscado = whenBuscoElUsuario(USUARIONUEVO);
		thenExisteElUsuarioLoMuestro(USUARIONUEVO, usuarioBuscado);
		
	}

	private void givenExisteUnUsuario(Usuario nuevo, Usuario nuevo2) {
		Usuario usuarioMock = nuevo2;
		when(this.repositorioUsuario.buscar(nuevo.getEmail())).thenReturn(usuarioMock);
		
	}
	
	private Usuario whenBuscoElUsuario(Usuario nuevo) {
		return this.servicioUsuario.buscarPorEmail(nuevo.getEmail());
	}
	
	private void thenExisteElUsuarioLoMuestro(Usuario nuevo, Usuario buscado) {
		
		assertEquals(nuevo.getEmail(), buscado.getEmail());
	}

}
