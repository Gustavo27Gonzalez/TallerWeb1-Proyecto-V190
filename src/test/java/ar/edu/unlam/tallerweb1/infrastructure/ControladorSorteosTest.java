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
import ar.edu.unlam.tallerweb1.controller.ControladorSorteo;
import ar.edu.unlam.tallerweb1.controller.ControladorUsuario;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.repository.RepositorioSorteo;
import ar.edu.unlam.tallerweb1.repository.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.service.ServicioSorteo;
import ar.edu.unlam.tallerweb1.service.ServicioUsuario;

public class ControladorSorteosTest extends SpringTest {

	   public static final int CANTIDAD_SORTEOS = 5;
	   public static final int CANTIDAD_USUARIOS = 4;
	   public static final int CANTIDAD_PARTICIPANTES = 3;
	   private ControladorSorteo controladorSorteo;
	   private ControladorUsuario controladorUsuario;
	   private ServicioSorteo servicioSorteo;
	   private ServicioUsuario servicioUsuario;
	   private RepositorioSorteo repositorioSorteo;
	   private RepositorioUsuario repositorioUsuario;
	   
	   //private HttpServletRequest request;

	    @Before
	    public void init(){
	        this.servicioSorteo = mock(ServicioSorteo.class);
	        this.controladorSorteo = new ControladorSorteo(this.servicioSorteo);
	        this.servicioUsuario = mock(ServicioUsuario.class);
	        this.repositorioSorteo = mock(RepositorioSorteo.class);
	        this.repositorioUsuario = mock(RepositorioUsuario.class);
	        this.controladorUsuario = new ControladorUsuario(this.servicioSorteo, this.servicioUsuario);
	    }
	    
	    // Test Listado Sorteos

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

	    private void dadoQueExistenSorteos(int cantidadSorteos) {
//	        this.servicioSorteo = new ServicioSorteoImpl();
	    	
	        List<Sorteo> sorteos = new LinkedList<>();
	        for(int i = 0; i<5; i++) {
	        	sorteos.add(new Sorteo());
	        	this.repositorioSorteo.crear(new Sorteo());
	        }
	            
	        when(this.repositorioSorteo.listarSorteos()).thenReturn(sorteos);
	    }
	    
	    
	    // Test quiero participar en 1 sorteo
	    
	    @Test
	    public void quieroParticiparEnUnSorteo() {
	    	givenHayUnSorteoExistenteQueQuieroParticipar();
	    	ModelAndView model = whenGeneroLaAccionDeParticiparEnUnSorteo();
	    	thenIngresoALaVistaParaParticiparDeEseSorteo(model, "participar");
	    }

		private void thenIngresoALaVistaParaParticiparDeEseSorteo(ModelAndView model, String vistaEsperada) {
			assertThat(model.getViewName()).isEqualTo(vistaEsperada);
		}

		private ModelAndView whenGeneroLaAccionDeParticiparEnUnSorteo() {
			return controladorSorteo.participar();
		}

		private void givenHayUnSorteoExistenteQueQuieroParticipar() {
			Usuario usuarioExistente = new Usuario(2L, "Martin", "martin@gmail.com", Boolean.TRUE);
			DatosSorteo datosSorteo = new DatosSorteo((long) 123123, "Mock","Mock-Service", 150.00, 10);
			Sorteo nuevoSorteo = new Sorteo(datosSorteo);
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
		
		
		// Test Listar Participantes del sorteo
	    
	    @Test
	    public void alPedirTodosLosParticipantesObtengoLaListaCompleta(){
	        // Preparacion
	    	Sorteo sorteo = dadoQueExiste1Sorteo(1);
	        dadoQueExistenParticipantes(CANTIDAD_PARTICIPANTES);

	        // Ejecucion
	        ModelAndView mav = cuandoListoParticipantes(sorteo);

	        // Verificacion
	        entoncesEncuentroParticipantes(mav, CANTIDAD_PARTICIPANTES);
	        
	        entoncesMeLLevaALaVistaParticipantes(mav, "lista-participantes");
	    }

	    private void entoncesMeLLevaALaVistaParticipantes(ModelAndView mav, String vistaEsperada) {
	        assertThat(mav.getViewName()).isEqualTo(vistaEsperada);
	    }

	    private void entoncesEncuentroParticipantes(ModelAndView mav, int cantidadUsuariosEsperados){
	        assertThat((List<Usuario>)mav.getModel().get("usuarios")).hasSize(cantidadUsuariosEsperados);
	    }

	    private ModelAndView cuandoListoParticipantes(Sorteo sorteo){
	        return controladorSorteo.listarParticipantes(sorteo);
	    }
	    
	    private void dadoQueExistenParticipantes(int cantidadParticipantes) {
//	        this.servicioSorteo = new ServicioSorteoImpl();
	    	String aux = "";
	        List<Usuario> participantes = new LinkedList<>();
	        for(Integer i = 0; i<cantidadParticipantes; i++) {
	        	aux = i.toString();
	        	Usuario u = new Usuario(aux, aux);
	        	participantes.add(u);
	        	this.repositorioUsuario.guardar(u);
	        	
	        	this.repositorioUsuario.guardarCompra(new Compra(null, u));
	        }
	            
	        when(this.repositorioUsuario.listarUsuarios()).thenReturn(participantes);
	    }

	    private Sorteo dadoQueExiste1Sorteo(int cantidadSorteos) {
	    	DatosSorteo datosSorteo = new DatosSorteo("sorteo1", "unico sorteo", 100.00, 50);
	        return new Sorteo(datosSorteo);
	    }
		
	    
	    // Test Algoritmo Ganador
		
		@Test
	    public void alRealizarElSorteoComprueboQueElAlgoritmoGenereMasChancesDeGanarAlQueCumpleConMasRequisitos(){
	    	
	    	// Factores que incrementan las chances:
	    	// 1) Cantidad de Rifas compradas en este sorteo. 2) Si ya gan� un sorteo.
	    	
	        // Preparacion
	        dadoQueExistenSorteos(CANTIDAD_SORTEOS);
	        dadoQueExistenUsuarios(CANTIDAD_USUARIOS);

	        // Ejecucion
	        givenHayUnSorteoExistenteQueQuieroParticipar();
	    	ModelAndView model = whenGeneroLaAccionDeParticiparEnUnSorteo();
	    	thenIngresoALaVistaParaParticiparDeEseSorteo(model, "participar");
	    	
	    	ModelAndView mav = obtenerGanador();
	        // Verificacion
	    	entoncesMeDevuelveElGanador(mav, "ganador");
	    }
	    
	    private void entoncesMeDevuelveElGanador(ModelAndView mav, String vistaEsperada) {
	    	assertThat(mav.getViewName()).isEqualTo(vistaEsperada);
		}

		private ModelAndView obtenerGanador() {
			return controladorSorteo.obtenerGanador();
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
	    
	    
	}