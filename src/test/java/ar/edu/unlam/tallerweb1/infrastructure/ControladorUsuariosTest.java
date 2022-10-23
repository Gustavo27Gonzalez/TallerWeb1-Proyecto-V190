package ar.edu.unlam.tallerweb1.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controller.ControladorUsuario;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosRegistro;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.repository.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.service.ServicioLogin;
import ar.edu.unlam.tallerweb1.service.ServicioSorteo;
import ar.edu.unlam.tallerweb1.service.ServicioUsuario;
import ar.edu.unlam.tallerweb1.service.serviceImpl.ServicioLoginImpl;

public class ControladorUsuariosTest extends SpringTest {

	   public static final int CANTIDAD_USUARIOS = 4;
	   private ControladorUsuario controladorUsuario;
	   private ServicioSorteo servicioSorteo;
	   private ServicioUsuario servicioUsuario;
	   //private HttpServletRequest request;
	   private ServicioLogin servicioLogin;
	   private RepositorioUsuario repositorioUsuario;

	    @Before
	    public void init(){
	        servicioUsuario = mock(ServicioUsuario.class);
	        repositorioUsuario = mock(RepositorioUsuario.class);
	        
	        controladorUsuario = new ControladorUsuario(this.servicioSorteo, this.servicioUsuario);
	        
	        servicioLogin = new ServicioLoginImpl(repositorioUsuario);
	    }
	    
	    // Test Guardar Usuario Nuevo
	    
	    @Test
	    public void guardarUsuarioNuevoSiElRegistroEsExitoso(){

	        cuandoRegistroUnUsuario("admin@admin.com", "1234");

	        entoncesSeGuardaElUsuario("admin@admin.com", "1234");
	    }

	    @Test(expected = Exception.class)
	    public void lanzarErrorAlRegistrarUnUsuarioExistente(){
	        dadoQueExisteElUsuario("usuario@no-registrado.com");

	        cuandoRegistroUnUsuario("usuario@no-registrado.com");
	    }

	    private void dadoQueExisteElUsuario(String usuarioQueYaExiste) {
	        Usuario usuario= new Usuario();
	        when(repositorioUsuario.buscarPorEmail(usuarioQueYaExiste)).thenReturn(usuario);
	    }

	    private void cuandoRegistroUnUsuario(String usuario) {
	        cuandoRegistroUnUsuario(usuario, "");
	    }

	    private void cuandoRegistroUnUsuario(String usuario, String clave) {
	        servicioLogin.registrar(usuario, clave);
	    }

	    private void entoncesSeGuardaElUsuario(String usuario, String clave) {
	        Usuario nuevoUsuario = new Usuario();
	        nuevoUsuario.setEmail(usuario);
	        nuevoUsuario.setPassword(clave);

	        verify(repositorioUsuario).guardar(any(Usuario.class));
	        // ArgumentMatchers
	    }
	    
	    // Test Obtener Lista de Usuarios

	    @Test
	    public void alPedirTodosLosUsuariosObtengoLaListaCompleta(){
	        // Preparacion
	        dadoQueExistenUsuarios(CANTIDAD_USUARIOS);

	        // Ejecucion
	        ModelAndView mav = cuandoListoUsuarios();

	        // Verificacion
	        entoncesEncuentro(mav, CANTIDAD_USUARIOS);
	        
	        entoncesMeLLevaALaVista(mav, "lista-usuarios");
	    }

	    private void entoncesMeLLevaALaVista(ModelAndView mav, String vistaEsperada) {
	        assertThat(mav.getViewName()).isEqualTo(vistaEsperada);
	    }

	    private void entoncesEncuentro(ModelAndView mav, int cantidadUsuariosEsperados){
	        assertThat((List<Usuario>)mav.getModel().get("usuarios")).hasSize(cantidadUsuariosEsperados);
	    }

	    private ModelAndView cuandoListoUsuarios(){
	        return controladorUsuario.listarUsuarios();
	    }

	    private void dadoQueExistenUsuarios(int cantidadUsuarios) {
	        List<Usuario> usuarios = new LinkedList<>();
	        for(int i = 0; i < cantidadUsuarios; i++)
	            usuarios.add(new Usuario());
	        when(this.servicioUsuario.listarUsuarios()).thenReturn(usuarios);
	    }
	    
	   

}