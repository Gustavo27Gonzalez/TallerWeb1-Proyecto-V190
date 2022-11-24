package ar.edu.unlam.tallerweb1.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.repository.RepositorioSorteo;
import ar.edu.unlam.tallerweb1.service.ServicioSorteo;
import ar.edu.unlam.tallerweb1.service.serviceImpl.ServicioSorteoImpl;

public class ServiceSorteoTest extends SpringTest {
	
 	public static final int CANTIDAD_SORTEOS = 5;
	private ServicioSorteo servicioSorteo;
	private RepositorioSorteo repositorioSorteo;

	@Before
	public void init(){
		this.repositorioSorteo = mock(RepositorioSorteo.class);
		this.servicioSorteo = new ServicioSorteoImpl(this.repositorioSorteo);
	}

	@Test
	public void alSortearGanadorObtengoRifaGanadora() {
		Sorteo sorteo = dadoUnSorteo();

		List<Rifa> rifas = entoncesBuscoRifasVendidasDelSorteo(sorteo);

		entoncesObtengoUnaRifaGanadora(rifas);
	}

	private List<Rifa> entoncesBuscoRifasVendidasDelSorteo(Sorteo sorteo) {
		// Todo do this more real
		List<Rifa> rifas = new ArrayList();
		rifas.add(new Rifa());
		rifas.add(new Rifa());
		return rifas;
	}

	private void entoncesObtengoUnaRifaGanadora(List<Rifa> rifas) {
		Rifa rifa = this.servicioSorteo.obtenerGanador(rifas);
		assertThat(rifa).isNotNull();
	}

	private Sorteo dadoUnSorteo() {
		return new Sorteo();
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

}
