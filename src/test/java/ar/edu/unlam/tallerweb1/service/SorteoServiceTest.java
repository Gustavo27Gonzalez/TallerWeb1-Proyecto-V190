package ar.edu.unlam.tallerweb1.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.repository.SorteoRepository;
import ar.edu.unlam.tallerweb1.service.serviceImpl.SorteoServiceImpl;

public class SorteoServiceTest extends SpringTest{
	
	private static final DatosSorteo DATOS_SORTEO = new DatosSorteo(859, "Mock","Mock-Service", 150.00, 10);
	private static final Sorteo SORTEO = new Sorteo(DATOS_SORTEO);
	private SorteoRepository sorteoRepository; /*= mock(SorteoRepository.class);*/
	private SorteoService sorteoService; /*= new SorteoServiceImpl(sorteoRepository);*/
	
	@Before
	public void init() {
		this.sorteoRepository = mock(SorteoRepository.class);
        this.sorteoService = new SorteoServiceImpl(this.sorteoRepository);
	}

	@Test
	public void quieroGenerarUnSorteoYLuegoListarTodosLosQueHay() {
		dadoQueExisteUnSorteo(SORTEO);
		Sorteo buscado = cuandoBuscoElSorteoPorSuId(SORTEO.getId());
		entoncesLoEncuentro(buscado);
	}

	private void dadoQueExisteUnSorteo(Sorteo nuevo) {
		when(sorteoRepository.buscarPorId(nuevo.getId())).thenReturn(nuevo);
	}

	private Sorteo cuandoBuscoElSorteoPorSuId(Integer id) {
		return this.sorteoService.buscarPorId(id);
	}

	private void entoncesLoEncuentro(Sorteo sorteo) {
		assertThat(sorteo).isEqualTo(sorteo);
		
	}

}
