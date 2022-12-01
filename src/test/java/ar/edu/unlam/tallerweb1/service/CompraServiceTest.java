package ar.edu.unlam.tallerweb1.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import ar.edu.unlam.tallerweb1.models.enums.TipoAlgoritmo;
import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.repository.RepositorioRifa;
import ar.edu.unlam.tallerweb1.service.serviceImpl.ServicioRifaImpl;

public class CompraServiceTest {
	private ServicioRifa servicioRifa;
	private RepositorioRifa repositorioRifa;
	
	@Before
	public void init() {
		this.repositorioRifa = mock(RepositorioRifa.class);
        this.servicioRifa = new ServicioRifaImpl(this.repositorioRifa);
	}

	@Test
	public void siendoQueExisteUnSorteoPuedoComprarUnNumero() {
		DatosSorteo datosSorteo = new DatosSorteo((long) 123123, "Mock","Mock-Service", 150.00, 10, TipoAlgoritmo.RANDOM);
		Usuario usuario = new Usuario(1L, "Agustin", "Agustin@test.com", Boolean.FALSE);
		Sorteo sorteo = new Sorteo(datosSorteo, usuario.getId());
		Rifa rifa = new Rifa(1L, false, sorteo);
		Compra compra = new Compra(rifa, usuario);
		dadoQueExisteUnSorteoConUnaRifaYLaQuieroComprar(compra);
		Compra compraExitosa = cuandoQuieroComprarUnNumeroDeUnaRifa(compra);
		entoncesLaCompraEsExitosa(compraExitosa);
	}
	
	private void dadoQueExisteUnSorteoConUnaRifaYLaQuieroComprar(Compra compra) {
		when(this.repositorioRifa.comprar(compra)).thenReturn(compra);
	}

	private Compra cuandoQuieroComprarUnNumeroDeUnaRifa(Compra compra) {
		return this.servicioRifa.comprarRifa(compra);
	}

	private void entoncesLaCompraEsExitosa(Compra compraExitosa) {
		assertThat(compraExitosa).isNotNull();
	}
	
}
