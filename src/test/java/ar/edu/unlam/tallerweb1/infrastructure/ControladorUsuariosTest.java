package ar.edu.unlam.tallerweb1.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
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
import ar.edu.unlam.tallerweb1.service.ServicioSorteo;
import ar.edu.unlam.tallerweb1.service.ServicioUsuario;

public class ControladorUsuariosTest extends SpringTest {

	   public static final int CANTIDAD_USUARIOS = 4;
	   private ControladorUsuario controladorUsuario;
	   private ServicioSorteo servicioSorteo;
	   private ServicioUsuario servicioUsuario;
	   private HttpServletRequest request;

	    @Before
	    public void init(){
	        this.servicioUsuario = mock(ServicioUsuario.class);
	        this.controladorUsuario = new ControladorUsuario(this.servicioSorteo, this.servicioUsuario);
	    }

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