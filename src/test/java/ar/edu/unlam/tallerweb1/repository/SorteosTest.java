package ar.edu.unlam.tallerweb1.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosRegistro;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;

public class SorteosTest {

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
}
