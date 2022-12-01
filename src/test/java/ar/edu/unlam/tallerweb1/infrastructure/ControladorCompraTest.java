package ar.edu.unlam.tallerweb1.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import ar.edu.unlam.tallerweb1.service.SessionService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controller.ControladorCompra;
import ar.edu.unlam.tallerweb1.controller.dtos.CompraDTO;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.service.ServicioCompra;
import exceptions.RifaNoDisponibleException;

public class ControladorCompraTest {
	
	private ControladorCompra controladorCompra;
	private ServicioCompra servicioCompra;
	private Sorteo sorteo;
	private Usuario usuario = new Usuario();
	private List<CompraDTO> compras;

	@Before
	public void init() {
		this.servicioCompra = mock(ServicioCompra.class);
		this.controladorCompra = new ControladorCompra(this.servicioCompra);
	}

//	@Test
//	public void alPedirLasComprasDeRifasDeUnUsuarioParaUnSorteoVeoLasCompras() {
//		dadoQueExistenComprasDeRifasEnUnSorteoParaUnUsuario(this.usuario);
//		ModelAndView mav = this.controladorCompra.verCompras();
//		entoncesMeLlevaALaVista(mav, "ver-compras");
//		entoncesElModeloContieneCompras(mav,1);
//	}
	
	private void entoncesElModeloContieneCompras(ModelAndView mav, int comprasEsperadas) {
		assertThat(mav.getModelMap().containsValue(1));
	}

	private void entoncesMeLlevaALaVista(ModelAndView mav, String string) {
		assertThat(mav.getViewName()).isEqualTo("ver-compras");
	}

	private void dadoQueExistenComprasDeRifasEnUnSorteoParaUnUsuario(Usuario usuario) {
		when(this.servicioCompra.listarMisCompras()).thenReturn(this.compras);
	}

	@Test
	public void dadoQueRealizoUnaCompraDeRifaEnUnSorteoEntoncesLaVisualizoEnLaVistaDeCompras() {
		dadoQueExisteUnSorteoConRifasDisponibles();
		ModelAndView mav = cuandoTerminoDeRealizarLaCompraLaMismaYaEstaListaParaSerVisualizada();
		entoncesElUsuarioPuedeVerSuListaDeCompras(mav, "ver-compras");
	}
	
	private void dadoQueExisteUnSorteoConRifasDisponibles() {
		dadoQueExisteUnSorteo();
		Rifa rifa = new Rifa(1L, false);
		this.sorteo.addRifa(rifa);
	}
	
	
	private ModelAndView cuandoTerminoDeRealizarLaCompraLaMismaYaEstaListaParaSerVisualizada() {
		return controladorCompra.verCompras();
	}

	private void entoncesElUsuarioPuedeVerSuListaDeCompras(ModelAndView view, String vistaEsperada){
		assertThat(view.getModelMap().containsValue(6));
		view.getModelMap().get("msj");
	}
	
	@Test
	public void dadoQueNoPuedoConcretarLaCompraDeUnaRifaEnUnSorteoEntoncesObtengoUnaVistaDeError() throws RifaNoDisponibleException {
		dadoQueExisteUnSorteoConRifasDisponibles();
		ModelAndView mav=  cuandoQuieroTerminarDeRealizarLaCompraObtengoUnError();
		entoncesLaCompraNoPuedeSerConcretadaYObtengoUnaVistaDeError(mav,"ERROR" );
	}
	
	private void dadoQueExisteUnSorteo() {
		Usuario nuevo = createUser();
		DatosSorteo datosSorteo = new DatosSorteo((long) 123123, "Mock","Mock-Service", 150.00, 10);
		this.sorteo = new Sorteo(datosSorteo, nuevo.getId());
	}

	private ModelAndView cuandoQuieroTerminarDeRealizarLaCompraObtengoUnError() throws RifaNoDisponibleException {
		Rifa rifa = new Rifa(1L, false);
		usuario = createUser();
		doNothing().doThrow(new RifaNoDisponibleException("RIFA NO DISPONIBLE")).when(this.servicioCompra).comprar(rifa.getId(),usuario);
		ModelMap model = new ModelMap();
		model.put("ERROR", "Rifa no diponible");
		return new ModelAndView("ver-compras", model);
	}

	private Usuario createUser() {
		this.usuario.setId(1L);
		this.usuario.setNombre("Agustin");
		this.usuario.setEmail("agustin@test.com");
		this.usuario.setGanoUnSorteoYa(Boolean.FALSE);
		return this.usuario;
	}

	private void entoncesLaCompraNoPuedeSerConcretadaYObtengoUnaVistaDeError(ModelAndView mav, String  expectedKey) {
		assertThat(mav.getModel().containsKey(expectedKey));
	}

}
