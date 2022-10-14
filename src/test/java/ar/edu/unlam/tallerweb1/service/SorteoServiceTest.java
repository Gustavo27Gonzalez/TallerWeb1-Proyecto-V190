package ar.edu.unlam.tallerweb1.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.repository.RepositorioSorteo;
import ar.edu.unlam.tallerweb1.service.serviceImpl.ServicioSorteoImpl;

public class SorteoServiceTest extends SpringTest{
	
	private static final DatosSorteo DATOS_SORTEO = new DatosSorteo((long) 123123, "Mock","Mock-Service", 150.00, 10);
	private static final Sorteo SORTEO = new Sorteo(DATOS_SORTEO);
	private RepositorioSorteo sorteoRepository; /*= mock(SorteoRepository.class);*/
	private ServicioSorteo sorteoService; /*= new SorteoServiceImpl(sorteoRepository);*/
	
	@Before
	public void init() {
		this.sorteoRepository = mock(RepositorioSorteo.class);
        this.sorteoService = new ServicioSorteoImpl(this.sorteoRepository);
	}

	@Test
	public void quieroGenerarUnSorteoYLuegoListarTodosLosQueHay() {
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

}
