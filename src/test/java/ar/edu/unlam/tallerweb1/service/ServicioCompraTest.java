package ar.edu.unlam.tallerweb1.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controller.ControladorCompra;
import ar.edu.unlam.tallerweb1.controller.ControladorSorteo;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosRegistro;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosRifa;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.repository.RepositorioCompra;
import ar.edu.unlam.tallerweb1.repository.RepositorioSorteo;
import ar.edu.unlam.tallerweb1.service.serviceImpl.ServicioCompraImpl;
import ar.edu.unlam.tallerweb1.service.serviceImpl.ServicioSorteoImpl;

public class ServicioCompraTest extends SpringTest {

	private ControladorCompra controladorCompra;
	private ServicioSorteo servicioSorteo;
	private ServicioUsuario servicioUsuario;
	//private ServicioCompra servicioCompra;
	private ServicioRifa servicioRifa;
	private RepositorioCompra repositorioCompra;
	private ServicioCompra servicioCompra;
	

	@Before
	public void init() {
		this.repositorioCompra = mock(RepositorioCompra.class);
		this.servicioCompra = mock(ServicioCompra.class);
		this.servicioSorteo = mock(ServicioSorteo.class);
		this.servicioUsuario = mock(ServicioUsuario.class);
		this.servicioRifa = mock(ServicioRifa.class);
		this.servicioCompra = new ServicioCompraImpl(this.repositorioCompra);
		this.controladorCompra = new ControladorCompra(this.servicioSorteo, this.servicioUsuario, this.servicioRifa);
		
	}
	
	// Comprar Rifa de Sorteo
	
	@Test 
	public void queSePuedeComprarUnaRifa() {
		Usuario usuario = givenQueExiste1Usuario();
		Sorteo sorteo = givenQueExiste1Sorteo();
		Rifa rifa = givenQueExiste1Rifa(sorteo.getId());
		
		ModelAndView mav = whenQuieroComprarUnaRifa(usuario, rifa);
		
		thenMeMuestraLaPantallaDeCompra(mav, "comprar");
	}
	
	private void thenMeMuestraLaPantallaDeCompra(ModelAndView mav, String vistaEsperada) {
		assertThat(mav.getViewName()).isEqualTo(vistaEsperada);
	}

	private ModelAndView whenQuieroComprarUnaRifa(Usuario usuario, Rifa rifa) {
		return controladorCompra.comprar(usuario, rifa);
	}

	private Usuario givenQueExiste1Usuario() {
		DatosRegistro datosRegistro = new DatosRegistro("John", 12345678, "john.doe@mail.com", "1234");
		return new Usuario(datosRegistro);
	}

	private Rifa givenQueExiste1Rifa(Long id) {
		Sorteo s = this.servicioSorteo.buscarPorId(id);
		Long idRifa = (long) (Math.random()*100);
		DatosRifa datosRifa = new DatosRifa(s.getId(), idRifa );
		return new Rifa(datosRifa);
	}
	
	private Sorteo givenQueExiste1Sorteo() {
		DatosSorteo datosSorteo = new DatosSorteo("sorteo1", "unico sorteo", 100.00, 50);
		return new Sorteo(datosSorteo);
	}

	//*****************************//
	// Listar Compras
	
	public static final int CANTIDAD_COMPRAS = 2;
    private List<Compra> compras;
    
    

    @Test
    public void alPedirTodasLasComprasObtengoLaListaCompleta(){
        dadoQueExistenCompras(CANTIDAD_COMPRAS);

        List<Compra> compras = cuandoListoCompras();

        entoncesEncuentro(compras, CANTIDAD_COMPRAS);
    }

    private void entoncesEncuentro(List<Compra> compras, int cantidadComprasEsperadas){
        assertThat(compras).hasSize(cantidadComprasEsperadas);
    }

    private List<Compra> cuandoListoCompras(){
        return this.servicioCompra.listarCompras();
    }

    private void dadoQueExistenCompras(int cantidadCompras) {
//        this.servicioSorteo = new ServicioSorteoImpl();
    	
        List<Compra> compras = new LinkedList<>();
        for(int i = 0; i<cantidadCompras; i++) {
        	compras.add(new Compra());
        	this.repositorioCompra.guardar(new Compra());
        }
            
        when(this.repositorioCompra.listarCompras()).thenReturn(compras);
    }
	

}
