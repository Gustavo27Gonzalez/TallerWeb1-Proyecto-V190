package ar.edu.unlam.tallerweb1.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controller.ControladorCompra;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.service.ServicioCompra;

public class ControladorCompraTest {
	
	private ControladorCompra controladorCompra;
	private ServicioCompra servicioCompra;
	
	@Before
	public void init() {
		this.servicioCompra = mock(ServicioCompra.class);
		this.controladorCompra = new ControladorCompra(this.servicioCompra);
	}

	@Test
	public void dadoQueRealizoUnaCompraEntoncesPuedoVisualizarlaEnLaVista() {
		Compra nueva = dadoQueTengoUnaCompraRealizada();
		ModelAndView mav = cuandoTerminoDeRealizarLaCompraLaMismaYaEstaListaParaSerVisualizada();
		entoncesPuedoVerMiCompraHecha(mav, "ver-compras");
	}
	
	private Compra dadoQueTengoUnaCompraRealizada() {
		DatosSorteo datosSorteo = new DatosSorteo((long) 123123, "Mock","Mock-Service", 150.00, 10);
		Sorteo sorteo = new Sorteo(datosSorteo);
		Rifa rifa = new Rifa(1L, false, sorteo);
		Usuario usuario = new Usuario(1L, "Agustin", "Agustin@test.com", Boolean.FALSE);
		Compra compra = new Compra(rifa, usuario);
		return compra;
	}
	
	private ModelAndView cuandoTerminoDeRealizarLaCompraLaMismaYaEstaListaParaSerVisualizada() {
		return controladorCompra.verCompras();
	}

	private void entoncesPuedoVerMiCompraHecha(ModelAndView view, String vistaEsperada) {
		assertThat(view.getModelMap().containsValue(6));
	}

}
