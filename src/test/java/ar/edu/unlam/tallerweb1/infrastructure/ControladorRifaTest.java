package ar.edu.unlam.tallerweb1.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpRequest;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controller.ControladorRifa;
import ar.edu.unlam.tallerweb1.controller.ControladorSorteo;
import ar.edu.unlam.tallerweb1.controller.ControladorUsuario;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosRegistro;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosRifa;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.service.ServicioRifa;
import ar.edu.unlam.tallerweb1.service.ServicioSorteo;
import ar.edu.unlam.tallerweb1.service.ServicioUsuario;

public class ControladorRifaTest extends SpringTest {

	private DatosSorteo sorteo;
	//private ControladorSorteo controladorSorteo;
	private ServicioSorteo servicioSorteo;
	private ServicioRifa servicioRifa;
	private ControladorRifa controladorRifa;
	

	@Before
	public void init() {
		this.servicioRifa = mock(ServicioRifa.class);
		this.controladorRifa = new ControladorRifa(this.servicioRifa);
		//this.controladorSorteo = new ControladorSorteo(null, this.servicioRifa);
		
	}
	
	// TEST obtener rifas sorteo
	
	@Test
	public void queNoSePuedeObtenerRifasDeUnSorteoQueNoTiene() {
		dadoQueExiste1Sorteo();
		//Mock del servicio
		dadoQueNoExistenRifasParaUnSorteo(this.sorteo);
		
		ModelAndView mav = cuandoObtengoLasRIfas(this.sorteo);
		
		entoncesMeLlevaAlaVista(mav, "ver-rifas");
		
		entoncesContieneRifas(mav);
	}
	
	private void entoncesContieneRifas(ModelAndView mav) {
		//assertThat((List<Rifa>)mav.getModel().get("rifa")).hasSize(cantidadEsperada);
		assertThat((List<Rifa>)mav.getModel().get("rifa")).isNull();
	}

	private void entoncesMeLlevaAlaVista(ModelAndView mav, String vistaEsperada) {
		assertThat(mav.getViewName()).isEqualTo(vistaEsperada);
	}
	
	private void dadoQueNoExistenRifasParaUnSorteo(DatosSorteo s) {
		List<DatosRifa> listaEsperada = new ArrayList<>();
		when(this.servicioRifa.obtenerPorIdSorteo(s.getIdSorteo())).thenReturn(listaEsperada);
	}

	private ModelAndView cuandoObtengoLasRIfas(DatosSorteo sorteo) {
		
		return this.controladorRifa.obtenerPorIdSorteo(sorteo.getIdSorteo());
		
	}

	private void dadoQueExiste1Sorteo() {
		this.sorteo = new DatosSorteo( 1L,"sorteito", "prueba", 150.00, 10);	
	}

	// Comprar Rifa de Sorteo
	
	@Test 
	public void queSePuedeComprarUnaRifa() {
		Usuario usuario = givenQueExiste1Usuario();
		Sorteo sorteo = givenQueExiste1Sorteo();
		Rifa rifa = givenQueExiste1Rifa(sorteo);
		
		ModelAndView mav = whenQuieroComprarUnaRifa(usuario, sorteo, rifa);
		
		thenMeMuestraLaPantallaDeCompra(mav, "comprar");
	}
	
	private Usuario givenQueExiste1Usuario() {
		DatosRegistro datosRegistro = new DatosRegistro("John", 12345678, "john.doe@mail.com", "1234");
		return new Usuario(datosRegistro);
	}

	private Rifa givenQueExiste1Rifa(Long id) {
		Sorteo s = this.servicioSorteo.obtenerSorteoPorId(id);
		return new Rifa(datosRifa);
	}

	// Listar Rifas en Un Sorteo

	@Test
	public void queSePuedanListarRifasEnUnSorteo() {
		givenQueExiste1Sorteo();
		
		ModelAndView mav = whenQuieroParticiparEnUnSorteoPuedoVerLasRifasDisponibles();
		thenMeMuestraLasRifasDisponibles(mav, "participar");

	}

	private void thenMeMuestraLasRifasDisponibles(ModelAndView model, String vistaEsperada) {
		assertThat(model.getViewName()).isEqualTo(vistaEsperada);	
	}

	private ModelAndView whenQuieroParticiparEnUnSorteoPuedoVerLasRifasDisponibles() {
		return controladorSorteo.listarRifas();

	}

	private Sorteo givenQueExiste1Sorteo() {
		DatosSorteo datosSorteo = new DatosSorteo("sorteo1", "unico sorteo", 100.00, 50);
		return new Sorteo(datosSorteo);
	}
}