package ar.edu.unlam.tallerweb1.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.models.enums.TipoAlgoritmo;
import ar.edu.unlam.tallerweb1.service.serviceImpl.ServicioAlgoritmo;
import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.repository.RepositorioSorteo;
import ar.edu.unlam.tallerweb1.service.serviceImpl.ServicioSorteoImpl;

public class SorteoServiceTest extends SpringTest{
	
	private static final DatosSorteo DATOS_SORTEO = new DatosSorteo((long) 123123, "Mock","Mock-Service", 150.00, 10);
	private static final Sorteo SORTEO = new Sorteo(DATOS_SORTEO);
	private RepositorioSorteo sorteoRepository; /*= mock(SorteoRepository.class);*/
	private ServicioSorteo sorteoService; /*= new SorteoServiceImpl(sorteoRepository);*/
	private ServicioAlgoritmo servicioAlgoritmo;

	@Before
	public void init() {
		this.sorteoRepository = mock(RepositorioSorteo.class);
        this.sorteoService = new ServicioSorteoImpl(this.sorteoRepository);
		this.servicioAlgoritmo = new ServicioAlgoritmo();
	}

	@Test
	public void quieroGenerarUnSorteoYLuegoListarlo() {
		dadoQueExisteUnSorteo(SORTEO);
		Sorteo buscado = cuandoBuscoElSorteoPorSuId(SORTEO.getId());
		entoncesLoEncuentro(buscado);
	}

	@Test
	public void quieroElegirAlgoritmoPreseleccionadoYObtenerGanador() {
		dadoQueExisteUnSorteoConUnaRifaGanadora(SORTEO);
		cuandoSeleccionoElAlgoritmo(TipoAlgoritmo.PRESELECCIONADO);
		entoncesObtengoUnGanadorConRifaId(17);
	}

	@Test
	public void quieroElegirAlgoritmoRandomYObtenerGanadorRandom() {
		dadoQueExisteUnSorteoConUnaRifaGanadora(SORTEO);
		cuandoSeleccionoElAlgoritmo(TipoAlgoritmo.PRESELECCIONADO);
		entoncesObtengoUnGanadorConRifaIdRandom();
	}

	private void entoncesObtengoUnGanadorConRifaId(long ganadorId) {
		this.servicioAlgoritmo.setTipo(SORTEO.getAlgoritmo());
		Rifa ganador = this.servicioAlgoritmo.getGanador(SORTEO.getRifas());
		assertThat(ganador.getId()).isEqualTo(ganadorId);
	}

	private void entoncesObtengoUnGanadorConRifaIdRandom() {
		this.servicioAlgoritmo.setTipo(SORTEO.getAlgoritmo());
		Rifa ganador = this.servicioAlgoritmo.getGanador(SORTEO.getRifas());
		assertThat(ganador.getId()).isNotNull();
	}

	private void cuandoSeleccionoElAlgoritmo(TipoAlgoritmo algoritmo) {
		SORTEO.setAlgoritmo(algoritmo);
	}

	private void dadoQueExisteUnSorteo(Sorteo sorteo) {
		this.dadoQueExisteUnSorteoConUnaRifaGanadora(sorteo);
	}
	private void dadoQueExisteUnSorteoConUnaRifaGanadora(Sorteo nuevo) {
		nuevo.addRifa(new Rifa(13L,true));
		nuevo.addRifa(new Rifa(14L,true));
		nuevo.addRifa(new Rifa(15L,true));
		Rifa rifa = new Rifa(17L,true);
		rifa.setEsGanadora(true);
		nuevo.addRifa(rifa);
		nuevo.addRifa(new Rifa(18L,true));
		sorteoRepository.crear(nuevo);
	}

	private Sorteo cuandoBuscoElSorteoPorSuId(Long id) {
		return this.sorteoService.buscarPorId(id);
	}

	private void entoncesLoEncuentro(Sorteo sorteo) {
		assertThat(sorteo).isEqualTo(sorteo);
	}

	@Test
	public void quieroGenerarUnSorteoYSeGuardaCorrectamente(){
		givenQueCreoUnSorteo(DATOS_SORTEO);
		thenSeGuardaCorrectamente(DATOS_SORTEO);
	}

	private void thenSeGuardaCorrectamente(DatosSorteo sorteo) {
		Sorteo nuevo = new Sorteo (sorteo);
		verify(sorteoRepository).crear(any(Sorteo.class));
	}

	private void givenQueCreoUnSorteo(DatosSorteo sorteo) {
		sorteoService.crear(sorteo);
	}	
	
	@Test
	public void quieroVerLaListaDeSorteosDisponibles(){
		givenQueTengoUnaListaDeSorteosQueFueronCreados();
		List<Sorteo> listaSorteos = whenSolicitoLosSorteosMeLosLista();
		thenPuedoVisualizarLosSorteos(listaSorteos);
	}

	private void thenPuedoVisualizarLosSorteos(List listaSorteos) {
		assertThat(listaSorteos).asList();
	}

	private List<Sorteo> whenSolicitoLosSorteosMeLosLista() {
		return this.sorteoService.listarSorteos();
	}

	private void givenQueTengoUnaListaDeSorteosQueFueronCreados() {
		List<Sorteo> listaSorteos = obtenerSorteos();
		when(this.sorteoService.listarSorteos()).thenReturn(listaSorteos);
	}

	private List<Sorteo>obtenerSorteos() {
		List<Sorteo> sorteos = new ArrayList<Sorteo>();
		sorteos.add(SORTEO);
		sorteos.add(SORTEO);
		sorteos.add(SORTEO);
		return sorteos;
	}
	
	
}
