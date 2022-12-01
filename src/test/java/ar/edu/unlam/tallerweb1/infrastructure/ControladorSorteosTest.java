package ar.edu.unlam.tallerweb1.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ar.edu.unlam.tallerweb1.repository.RepositorioSorteo;
import ar.edu.unlam.tallerweb1.service.ServicioRifa;
import ar.edu.unlam.tallerweb1.service.SessionService;
import ar.edu.unlam.tallerweb1.service.serviceImpl.ServicioMercadoPagoImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controller.ControladorSorteo;
import ar.edu.unlam.tallerweb1.controller.ControladorUsuario;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.service.ServicioSorteo;
import ar.edu.unlam.tallerweb1.service.ServicioUsuario;

public class ControladorSorteosTest extends SpringTest {

	public static final int CANTIDAD_SORTEOS = 5;
	public static final int CANTIDAD_USUARIOS = 4;
	private ControladorSorteo controladorSorteo;
	private ControladorUsuario controladorUsuario;
	private ServicioSorteo servicioSorteo;
	private ServicioUsuario servicioUsuario;
	private RepositorioSorteo repositorioSorteo;
	private ServicioRifa servicioRifa;
	private SessionService sessionService;

	@Before
	public void init(){
		this.servicioSorteo = mock(ServicioSorteo.class);
		this.servicioRifa = mock(ServicioRifa.class);
		this.sessionService = mock(SessionService.class);
		this.controladorSorteo = new ControladorSorteo(this.servicioSorteo, null,mock(SessionService.class),mock(ServicioMercadoPagoImpl.class));
		this.servicioUsuario = mock(ServicioUsuario.class);
		this.repositorioSorteo = mock(RepositorioSorteo.class);
	}

	@Test
	public void alSortearObtengoUnGanador() {
		Sorteo sorteo = dadoQueExisteUnSorteo();
		Usuario usuario = dadoQueExisteUnUsuario(1L, "q@test", "123", false);
		ModelAndView mav = cuandoSorteoElGanador(sorteo, usuario);
		entoncesMeLLevaALaVista(mav, "ganador");
	}

	private Usuario dadoQueExisteUnUsuario(long id, String nombre, String mail, boolean ganoAntes) {
		return new Usuario(id, nombre, mail, ganoAntes );
	}

	@Test
	public void alPedirTodosLosSorteosObtengoLaListaCompleta(){
		// Preparacion
		dadoQueExistenSorteos(CANTIDAD_SORTEOS);

		// Ejecucion
		ModelAndView mav = cuandoListoSorteos();

		// Verificacion
		entoncesEncuentro(mav, CANTIDAD_SORTEOS);

		entoncesMeLLevaALaVista(mav, "listar-sorteos");
	}

	private void entoncesMeLLevaALaVista(ModelAndView mav, String vistaEsperada) {
		assertThat(mav.getViewName()).isEqualTo(vistaEsperada);
	}

	@SuppressWarnings("unchecked")
	private void entoncesEncuentro(ModelAndView mav, int cantidadSorteosEsperados){
		assertThat((ArrayList<Sorteo>)mav.getModel().get("sorteos")).hasSize(cantidadSorteosEsperados);
	}

	private ModelAndView cuandoListoSorteos(){
		return controladorSorteo.listarSorteos();
	}

	private ModelAndView cuandoSorteoElGanador(Sorteo sorteo, Usuario usuario) {
		when(this.servicioSorteo.obtenerUsuarioGanador(sorteo)).thenReturn(usuario);
		return controladorSorteo.sortearGanador(sorteo);
	}

	private void dadoQueExistenSorteos(int cantidadSorteos) {
		List<Sorteo> sorteos = new ArrayList<>();
		for(int i = 0; i < cantidadSorteos; i++)
			sorteos.add(new Sorteo());
		when(this.servicioSorteo.listarSorteos()).thenReturn(sorteos);
	}

	private void dadoQueExistenUsuarios(int cantidadUsuarios) {
		List<Usuario> usuarios = new LinkedList<>();

		List<String> nombres = new ArrayList<>();
		nombres.add("Julieta");
		nombres.add("Sergio");
		nombres.add("Mabel");
		nombres.add("Ricardo");

		List<Integer> totalRifasCompradas = new ArrayList<>();
		totalRifasCompradas.add(1);
		totalRifasCompradas.add(4);
		totalRifasCompradas.add(18);
		totalRifasCompradas.add(7);

		List<Boolean> ganoUnSorteoYa = new ArrayList<>();
		ganoUnSorteoYa.add(false);
		ganoUnSorteoYa.add(true);
		ganoUnSorteoYa.add(false);
		ganoUnSorteoYa.add(true);

		for(int i = 0; i < cantidadUsuarios; i++) {
		   // Usuario u = new Usuario(nombres.get(i), totalRifasCompradas.get(i), ganoUnSorteoYa.get(i));
			// INCOMPLETO
			Usuario u = new Usuario();

			usuarios.add(u);
		}

		when(this.servicioUsuario.listarUsuarios()).thenReturn(usuarios);
	}

	private ModelAndView cuandoListoUsuarios(){
		return controladorUsuario.listarUsuarios();
	}

	private void entoncesEncuentroUsuarios(ModelAndView mav, int cantidadUsuariosEsperados){
		assertThat((List<Usuario>)mav.getModel().get("usuarios")).hasSize(cantidadUsuariosEsperados);
	}

	//	    @Test
	//	    public void quieroParticiparEnUnSorteo() {
	//	    	givenHayUnSorteoExistenteQueQuieroParticipar();
	//	    	ModelAndView model = whenGeneroLaAccionDeParticiparEnUnSorteo();
	//	    	thenIngresoALaVistaParaParticiparDeEseSorteo(model, "participar");
	//	    }

	private void thenIngresoALaVistaParaParticiparDeEseSorteo(ModelAndView model, String vistaEsperada) {
		assertThat(model.getViewName()).isEqualTo(vistaEsperada);
	}

	private void givenHayUnSorteoExistenteQueQuieroParticipar() {
		Usuario usuarioExistente = new Usuario(2L, "Martin", "martin@gmail.com", Boolean.TRUE);
		DatosSorteo datosSorteo = new DatosSorteo((long) 123123, "Mock","Mock-Service", 150.00, 10);
		Sorteo nuevoSorteo = new Sorteo(datosSorteo, usuarioExistente.getId());
		List rifas = comprarRifas();
		when(servicioSorteo.participar(nuevoSorteo, usuarioExistente, rifas)).thenReturn(Boolean.TRUE);
		//doThrow(Exception.class).when(servicioSorteo).participar(nuevoSorteo, usuarioExistente);
	}

	private List comprarRifas() {
		List rifas = new LinkedList<Rifa>();
		for(int i=0; i<3; i++) {
			Rifa rifa = new Rifa(50L, Boolean.TRUE);
			rifas.add(rifa);
			rifa.setId(rifa.getId()+(i+20));
		}
		return rifas;
	}

	private Sorteo dadoQueExisteUnSorteo() {
		return new Sorteo();
	}
	    
}