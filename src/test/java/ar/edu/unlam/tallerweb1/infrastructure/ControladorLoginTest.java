package ar.edu.unlam.tallerweb1.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controller.ControladorLogin;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosLogin;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.service.ServicioLogin;
import exceptions.UsuarioLoginException;

public class ControladorLoginTest extends SpringTest{
	
	private ControladorLogin controladorLogin;
	private ServicioLogin servicioLogin;
	private HttpServletRequest request;
	private HttpSession session; 
	
	@Before
	public void init() {
		this.servicioLogin = mock(ServicioLogin.class);
		this.controladorLogin = new ControladorLogin(this.servicioLogin, null);
		this.request = mock(HttpServletRequest.class);
		this.session = mock(HttpSession.class);
	}
	
	@Test
	public void quieroIniciarSesionYMeLogueoDeFormaExitosa() throws UsuarioLoginException {
		DatosLogin login = new DatosLogin("email@test.com", "test123");
		givenExisteUnUsuarioQueQuiereLoguearseSeValidaCorrectamente(login);
		givenRealizoLaPeticionExitosaElControladorMeRedirijeALaVistaDeInicioCorrecta(login);
		ModelAndView mav = whenInicioSesionIngresoAlIndexCorrecto(login, request);
		thenInicioSesionYMeRedireccionaALaVistaDeInicioCorrectaYElUsuarioSeSeteaComoLogueado(mav, "redirect:/login-index");
	}

	private void givenExisteUnUsuarioQueQuiereLoguearseSeValidaCorrectamente(DatosLogin datosLogin) throws UsuarioLoginException {
		Usuario mock = new Usuario(datosLogin, Boolean.TRUE);
		when(this.servicioLogin.validarUsuario(datosLogin)).thenReturn(mock);
	}
	
	private void givenRealizoLaPeticionExitosaElControladorMeRedirijeALaVistaDeInicioCorrecta(DatosLogin login){
		givenSession();
		when(this.controladorLogin.validarLogin(login, this.request)).thenReturn(new ModelAndView("redirect:/login-index"));
	}
	
	private void givenSession(){
		when(this.request.getSession()).thenReturn(this.session);
	}

	private ModelAndView whenInicioSesionIngresoAlIndexCorrecto(DatosLogin datosLogin, HttpServletRequest request) {
		return this.controladorLogin.validarLogin(datosLogin, request);
	}

	private void thenInicioSesionYMeRedireccionaALaVistaDeInicioCorrectaYElUsuarioSeSeteaComoLogueado(ModelAndView mav, String expectedView) {
		assertThat(mav.getViewName()).isEqualTo(expectedView);
	}
	
	/*@Test
	public void quieroIniciarSesionConUnUsuarioQueNoExiste() throws UsuarioLoginException {
		DatosLogin login = new DatosLogin("email@test.com", "test123");
		givenExisteUnUsuarioQueQuiereLoguearse(login);
		ModelAndView mav = whenIntentoIniciarSesionTengoUnError(login, request);
		thenEstoyEnLaVistaDeLoginNuevamente();
	}

	private ModelAndView whenIntentoIniciarSesionTengoUnError(DatosLogin datosLogin, HttpServletRequest request) {
		return this.controladorLogin.validarLogin(datosLogin, request);
	}

	private void thenEstoyEnLaVistaDeLoginNuevamente() {
		// TODO Auto-generated method stub
		
	}*/
}
