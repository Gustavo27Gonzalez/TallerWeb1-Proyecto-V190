package ar.edu.unlam.tallerweb1.repository;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controller.ControladorSorteo;
import ar.edu.unlam.tallerweb1.controller.ControladorUsuario;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosRegistro;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;

public class SorteosTest extends SpringTest {
	
	private ControladorSorteo controladorSorteo;

    @Test
    public void sorteo(){
       //List<Sorteo> listaSorteos = new ArrayList<>();
       //listaSort

    }
    
    @Test
    public void queCreoUnUsuario(){
    	String nombre = "Gustavo";
    	Integer dni = 44333222;
    	String email = "gustavo@gmail.com";
    	String contrasenia = "Pass1234";
    	
    	DatosRegistro dr = new DatosRegistro(nombre, dni ,email, contrasenia);
    	
    	Usuario u = new Usuario(dr);
    	
    	assertNotNull(u);
    	assertEquals(u.getNombre(),nombre);
    	assertEquals(u.getDni(),dni);
    	assertEquals(u.getEmail(),email);
    	assertEquals(u.getPassword(),contrasenia);
    	assertNull(u.getTotalRifasCompradas());
    }
    
    @Test
    public void alSeleccionarVerTodosLosSorteosMeDevuelveLaListaConTodosLosSorteos() {
    	
    	dadoQueExistenSorteos(5);
    	
    	ModelAndView mav = controladorSorteo.listarSorteos();
    	
    	
    	assertThat((List<Sorteo>)mav.getModel().get("sorteos")).hasSize(5);
    }
    
    private void dadoQueExistenSorteos(int cantidadSorteos) {
    	this.controladorSorteo = new ControladorSorteo(cantidadSorteos);
    }
    
}