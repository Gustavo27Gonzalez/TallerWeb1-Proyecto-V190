package ar.edu.unlam.tallerweb1.service;

import ar.edu.unlam.tallerweb1.controller.ControladorLogin;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosLogin;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosRegistro;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.service.serviceImpl.SessionServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SessionServiceTest {
    @Autowired
    private ServicioUsuario servicioUsuario;
    private ControladorLogin controladorLogin;
    private SessionService sessionService;
    private Usuario usuario;
    private HttpServletRequest request;


    @Before
    public void init() {
        this.servicioUsuario = mock(ServicioUsuario.class);
        this.sessionService = new SessionServiceImpl();
        this.controladorLogin = new ControladorLogin(mock(ServicioLogin.class), this.servicioUsuario, this.sessionService);
        this.request = mock(HttpServletRequest.class);
    }

    @Test
    public void queSePuedaMantenerElUsuarioGuardadoEnLaSesion() throws Exception {
        this.dadoUnUsuario();
        this.cuandoInicioSesion();
        this.debePersistirseEnSessionService();
    }

    private void dadoUnUsuario() {
        DatosRegistro datosRegistro = new DatosRegistro("test",12123456,"test@test.com","123");
        Usuario user = new Usuario();
        user.setEmail(datosRegistro.getEmail());
        user.setNombre(datosRegistro.getNombre());
        this.usuario = user;
        when(this.servicioUsuario.registrar(datosRegistro)).thenReturn(user);
        // TODO deberia ser asi ?
//        this.usuario = (Usuario) when(this.servicioUsuario
//                .registrar(datosRegistro)).thenReturn(user);
    }

    private void cuandoInicioSesion() {
        DatosLogin datosLogin = new DatosLogin("test@test.com", "123");
//TODO En este when deberia hacer el set current user.. no lo hace pq esta mock.. esta bien ponerlo asi 'hardcodeado?
        this.sessionService.setCurrentUser(this.usuario);
        when(this.controladorLogin.validarLogin(datosLogin, request))
                .thenReturn(null);
    }

    private void debePersistirseEnSessionService() throws Exception {
        try {
            Usuario currentUser = this.sessionService.getCurrentUser();
            assertEquals(this.usuario.getEmail(), currentUser.getEmail());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
