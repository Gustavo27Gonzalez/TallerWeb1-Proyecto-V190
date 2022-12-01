package ar.edu.unlam.tallerweb1.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.models.enums.TipoAlgoritmo;
import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.repository.RepositorioSorteo;
import ar.edu.unlam.tallerweb1.service.serviceImpl.ServicioSorteoImpl;

public class SorteoServiceTest extends SpringTest{
	
	private static final DatosSorteo DATOS_SORTEO = new DatosSorteo((long) 123123, "Mock","Mock-Service", 150.00, 10, TipoAlgoritmo.RANDOM);
	private static final Sorteo SORTEO = new Sorteo(DATOS_SORTEO, null);
	private RepositorioSorteo sorteoRepository; /*= mock(SorteoRepository.class);*/
	private ServicioSorteo sorteoService; /*= new SorteoServiceImpl(sorteoRepository);*/
	private Usuario usuario;
	
	
	@Before
	public void init() {
		this.sorteoRepository = mock(RepositorioSorteo.class);
        this.sorteoService = new ServicioSorteoImpl(this.sorteoRepository);
	}

	@Test
	public void quieroGenerarUnSorteoYLuegoListarlo() {
		dadoQueExisteUnSorteo(SORTEO);
		Sorteo buscado = cuandoBuscoElSorteoPorSuId(SORTEO.getId());
		entoncesLoEncuentro(buscado);
	}

	private void dadoQueExisteUnSorteo(Sorteo nuevo) {
		when(sorteoRepository.buscarSorteoPorId(nuevo.getId())).thenReturn(nuevo);
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
		Usuario usuario = createUser();
		Sorteo nuevo = new Sorteo (sorteo, usuario.getId());
		verify(sorteoRepository).crear(any(Sorteo.class));
	}

	private void givenQueCreoUnSorteo(DatosSorteo sorteo) {
		sorteoService.crear(sorteo, this.usuario);
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
		Usuario usuario = createUser();
		SORTEO.setIdCreador(usuario.getId());
		List<Sorteo> sorteos = new ArrayList<Sorteo>();
		sorteos.add(SORTEO);
		sorteos.add(SORTEO);
		sorteos.add(SORTEO);
		return sorteos;
	}

	private Usuario createUser() {
		this.usuario.setId(1L);
		this.usuario.setNombre("Agustin");
		this.usuario.setEmail("agustin@test.com");
		this.usuario.setGanoUnSorteoYa(Boolean.FALSE);
		return this.usuario;
	}
}
