package ar.edu.unlam.tallerweb1.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosRegistro;

import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.repository.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.service.serviceImpl.ServicioUsuarioImpl;

public class UsuarioServiceTest extends SpringTest {

	private static final DatosRegistro DATOS_USUARIO = new DatosRegistro("User1", 12345678,"user1@user.com", "user1234");
	private static final Usuario USUARIO = new Usuario(DATOS_USUARIO);
	private RepositorioUsuario usuarioRepository; /*= mock(SorteoRepository.class);*/
	private ServicioUsuario usuarioService; /*= new SorteoServiceImpl(sorteoRepository);*/
	
	
	@Before
	public void init() {
		this.usuarioRepository = mock(RepositorioUsuario.class);
        this.usuarioService = new ServicioUsuarioImpl(this.usuarioRepository);
	}

	@Test
	public void quieroGenerarUnUsuarioYLuegoListarlo() {
		dadoQueExisteUnUsuario(USUARIO);
		Usuario usuarioBuscadoPorId = cuandoBuscoElUsuarioPorSuId(USUARIO.getId());
		Usuario usuarioBuscadoPorEmail = cuandoBuscoElUsuarioPorSuMail(USUARIO.getEmail());
		entoncesLoEncuentroPorSuId(usuarioBuscadoPorId);
		entoncesLoEncuentroPorSuEmail(usuarioBuscadoPorEmail);
	}

	private void dadoQueExisteUnUsuario(Usuario nuevoUsuario) {
		when(usuarioRepository.buscarId(nuevoUsuario.getId())).thenReturn(nuevoUsuario);
	}

	private Usuario cuandoBuscoElUsuarioPorSuId(Long id) {
		return this.usuarioService.buscarPorId(id);
	}
	
	private Usuario cuandoBuscoElUsuarioPorSuMail(String email) {
		return this.usuarioService.buscarPorEmail(email);
	}

	private void entoncesLoEncuentroPorSuId(Usuario usuario) {
		assertThat(usuario).isEqualTo(usuario);
	}
	
	private void entoncesLoEncuentroPorSuEmail(Usuario usuario) {
		assertThat(usuario).isEqualTo(usuario);
	}

	@Test
	public void quieroGenerarUnUsuarioYSeGuardaCorrectamente(){
		givenQueCreoUnUsuario(DATOS_USUARIO);
		thenSeGuardaCorrectamente(DATOS_USUARIO);
	}

	private void thenSeGuardaCorrectamente(DatosRegistro usuario) {
		Usuario nuevoUsuario = new Usuario (usuario);
		verify(usuarioRepository).guardar(any(Usuario.class));
	}

	private void givenQueCreoUnUsuario(DatosRegistro usuario) {
		usuarioService.registrar(usuario);
	}	
	
	@Test
	public void quieroVerLaListaDeUsuariosDisponibles(){
		givenQueTengoUnaListaDeUsuariosQueFueronCreados();
		List<Usuario> listaUsuarios = whenSolicitoLosUsuariosMeLosLista();
		thenPuedoVisualizarLosUsuarios(listaUsuarios);
	}

	private void thenPuedoVisualizarLosUsuarios(List<Usuario> listaUsuarios) {
		assertThat(listaUsuarios).asList();
	}

	private List<Usuario> whenSolicitoLosUsuariosMeLosLista() {
		return this.usuarioService.listarUsuarios();
	}

	private void givenQueTengoUnaListaDeUsuariosQueFueronCreados() {
		List<Usuario> listaUsuarios = obtenerUsuarios();
		when(this.usuarioService.listarUsuarios()).thenReturn(listaUsuarios);
	}

	private List<Usuario>obtenerUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(USUARIO);
		usuarios.add(USUARIO);
		usuarios.add(USUARIO);
		return usuarios;
	}

}
