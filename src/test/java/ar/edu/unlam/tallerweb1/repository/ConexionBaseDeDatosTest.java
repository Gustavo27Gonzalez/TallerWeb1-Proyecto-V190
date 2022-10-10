package ar.edu.unlam.tallerweb1.repository;

import ar.edu.unlam.tallerweb1.SpringTest;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

// Clase que prueba la conexion a la base de datos. Hereda de SpringTest por lo que corre dentro del contexto
// de spring
public class ConexionBaseDeDatosTest extends SpringTest{

    @Test
    @Transactional @Rollback
    public void pruebaConexion(){
        assertThat(session().isConnected()).isTrue();
    }

    @Test
    @Transactional @Rollback
    public void crearUsuario(){
        /*DatosLogin usuario = new DatosLogin();
        usuario.setEmail("seba@gmail.com");
>>>>>>> mapeoEntidades
        usuario.setPassword("1234");
        //usuario.setRol("ADMIN");
        session().save(usuario);
<<<<<<< HEAD
        assertThat(usuario.getId()).isNotNull();
=======
        */
        //assertThat(usuario.getId()).isNotNull();
    }
}
