package ar.edu.unlam.tallerweb1.repository;

import ar.edu.unlam.tallerweb1.SpringTest;
<<<<<<< HEAD
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;

=======
>>>>>>> mapeoEntidades
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
<<<<<<< HEAD
        Usuario usuario = new Usuario();
        usuario.setEmail("usuario1@gmail.com");
=======
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
>>>>>>> mapeoEntidades
    }
}
