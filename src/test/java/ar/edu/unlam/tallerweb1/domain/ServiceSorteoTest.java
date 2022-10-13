package ar.edu.unlam.tallerweb1.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.repository.RepositorioSorteo;
import ar.edu.unlam.tallerweb1.service.ServicioSorteo;
import ar.edu.unlam.tallerweb1.service.serviceImpl.ServicioSorteoImpl;

public class ServiceSorteoTest extends SpringTest {
	
	 public static final int CANTIDAD_SORTEOS = 5;
	    private List<Sorteo> sorteos;
	    private ServicioSorteo servicioSorteo;
	    private RepositorioSorteo repositorioSorteo;

	    @Before
	    public void init(){
	        this.repositorioSorteo = mock(RepositorioSorteo.class);
	        this.servicioSorteo = new ServicioSorteoImpl(this.repositorioSorteo);
	    }

	    @Test
	    public void alPedirTodosLosSorteosObtengoLaListaCompleta(){
	        dadoQueExistenSorteos(CANTIDAD_SORTEOS);

	        List<Sorteo> sorteos = cuandoListoSorteos();

	        entoncesEncuentro(sorteos, CANTIDAD_SORTEOS);
	    }

	    private void entoncesEncuentro(List<Sorteo> sorteos, int cantidadSorteosEsperados){
	        assertThat(sorteos).hasSize(cantidadSorteosEsperados);
	    }

	    private List<Sorteo> cuandoListoSorteos(){
	        return this.servicioSorteo.listarSorteos();
	    }

	    private void dadoQueExistenSorteos(int cantidadSorteos) {
//	        this.servicioSorteo = new ServicioSorteoImpl();
	    	
	        List<Sorteo> sorteos = new LinkedList<>();
	        for(int i = 0; i<5; i++) {
	        	sorteos.add(new Sorteo());
	        	this.repositorioSorteo.crear(new Sorteo());
	        }
	            
	        when(this.repositorioSorteo.listarSorteos()).thenReturn(sorteos);
	    }

<<<<<<< HEAD
}
=======
}
>>>>>>> origin/agustin_develop2
