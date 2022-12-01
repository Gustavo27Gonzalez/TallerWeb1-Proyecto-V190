//package ar.edu.unlam.tallerweb1.infrastructure;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;
//
//
//
//import ar.edu.unlam.tallerweb1.service.SessionService;
//
//import ar.edu.unlam.tallerweb1.service.serviceImpl.ServicioMercadoPagoImpl;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.http.HttpRequest;
//import org.springframework.web.servlet.ModelAndView;
//
//import ar.edu.unlam.tallerweb1.SpringTest;
//import ar.edu.unlam.tallerweb1.controller.ControladorSorteo;
//import ar.edu.unlam.tallerweb1.controller.ControladorUsuario;
//import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
//import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
//import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
//import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
//import ar.edu.unlam.tallerweb1.service.ServicioRifa;
//import ar.edu.unlam.tallerweb1.service.ServicioSorteo;
//import ar.edu.unlam.tallerweb1.service.ServicioUsuario;
//
//public class ControladorRifaTest extends SpringTest {
////
////	private ControladorSorteo controladorSorteo;
////	private ServicioSorteo servicioSorteo;
////	private ServicioRifa servicioRifa;
////	private SessionService sessionService;
////	private Usuario usuario;
////
////
////	@Before
////	public void init() {
////		this.servicioSorteo = mock(ServicioSorteo.class);
////		this.sessionService = mock(SessionService.class);
////		this.servicioRifa = mock(ServicioRifa.class);
////		this.controladorSorteo = new ControladorSorteo(null, this.servicioRifa, mock(SessionService.class),mock(ServicioMercadoPagoImpl.class));
////	}
////
////	@Test
////	public void queSePuedanListarRifasEnUnSorteo() throws Exception {
////		Sorteo sorteo = givenQueExiste1Sorteo();
////		ModelAndView mav = whenQuieroParticiparEnUnSorteoPuedoVerLasRifasDisponibles();
////		thenMeMuestraLasRifasDisponibles(mav, "participar");
////
////	}
////
////	private void thenMeMuestraLasRifasDisponibles(ModelAndView model, String vistaEsperada) {
////		assertThat(model.getViewName()).isEqualTo(vistaEsperada);
////	}
////
////	private ModelAndView whenQuieroParticiparEnUnSorteoPuedoVerLasRifasDisponibles() {
////		return controladorSorteo.listarRifas();
////
////	}
////
////	private Sorteo givenQueExiste1Sorteo() {
////		DatosSorteo datosSorteo = new DatosSorteo("sorteo1", "unico sorteo", 100.00, 50);
////		this.usuario = createUser();
////		return new Sorteo(datosSorteo,this.usuario.getId());
////	}
////
////	private Usuario createUser() {
////		this.usuario.setId(1L);
////		this.usuario.setNombre("Agustin");
////		this.usuario.setEmail("agustin@test.com");
////		this.usuario.setGanoUnSorteoYa(Boolean.FALSE);
////		return this.usuario;
////	}
//}