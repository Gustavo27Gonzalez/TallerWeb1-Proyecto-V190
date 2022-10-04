package ar.edu.unlam.tallerweb1.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controller.ControladorSorteo;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.service.ServicioSorteo;

public class ControladorSorteosTest extends SpringTest {

	   public static final int CANTIDAD_SORTEOS = 5;
	   private ControladorSorteo controladorSorteo;
	   private ServicioSorteo servicioSorteo;

	    @Before
	    public void init(){
	        this.servicioSorteo = mock(ServicioSorteo.class);
	        this.controladorSorteo = new ControladorSorteo(this.servicioSorteo);
	    }

	    @Test
	    public void alPedirTodosLosSorteosObtengoLaListaCompleta(){
	        // Preparacion
	        dadoQueExistenSorteos(CANTIDAD_SORTEOS);

	        // Ejecucion
	        ModelAndView mav = cuandoListoSorteos();

	        // Verificacion
	        entoncesEncuentro(mav, CANTIDAD_SORTEOS);
	        
	        entoncesMeLLevaALaVista(mav, "lista-sorteos");
	    }

	    private void entoncesMeLLevaALaVista(ModelAndView mav, String vistaEsperada) {
	        assertThat(mav.getViewName()).isEqualTo(vistaEsperada);
	    }

	    private void entoncesEncuentro(ModelAndView mav, int cantidadSorteosEsperados){
	        assertThat((List<Sorteo>)mav.getModel().get("sorteos")).hasSize(cantidadSorteosEsperados);
	    }

	    private ModelAndView cuandoListoSorteos(){
	        return controladorSorteo.listarSorteos();
	    }

	    private void dadoQueExistenSorteos(int cantidadSorteos) {
	        List<Sorteo> sorteos = new LinkedList<>();
	        for(int i = 0; i < cantidadSorteos; i++)
	            sorteos.add(new Sorteo());
	        when(this.servicioSorteo.listarSorteos()).thenReturn(sorteos);
	    }
	}
