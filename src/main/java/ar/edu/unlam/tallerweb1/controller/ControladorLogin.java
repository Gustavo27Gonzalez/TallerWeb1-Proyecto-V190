package ar.edu.unlam.tallerweb1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosLogin;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.service.ServicioLogin;
import ar.edu.unlam.tallerweb1.service.ServicioUsuario;
import exceptions.UsuarioLoginException;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorLogin {

	// La anotacion @Autowired indica a Spring que se debe utilizar el contructor
	// como mecanismo de inyección de dependencias,
	// es decir, qeue lo parametros del mismo deben ser un bean de spring y el
	// framewrok automaticamente pasa como parametro
	// el bean correspondiente, en este caso, un objeto de una clase que implemente
	// la interface ServicioLogin,
	// dicha clase debe estar anotada como @Service o @Repository y debe estar en un
	// paquete de los indicados en
	// applicationContext.xml

	@Autowired
	ServicioUsuario servicioUsuario;

	@Autowired
	ServicioLogin servicioLogin;

	@Autowired
	HttpServletRequest request;

	@Autowired
	public ControladorLogin(ServicioLogin servicioLogin, HttpServletRequest request) {
		this.servicioUsuario = servicioUsuario;
		this.servicioLogin = servicioLogin;
		this.request = request;
	}

	// Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la
	// url /login directamente.
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/login");
	}

	// Escucha la URL /home por GET, y redirige a una vista.
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome() {
		if (request.getSession().getAttribute("Estado") == "Activo") {
			ModelMap modelo = new ModelMap();
			Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
			Usuario usuario = servicioUsuario.buscarPorId(idUsuario);
			return new ModelAndView("home", modelo);
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	public boolean estaLogueado() {
		if (request.getSession().getAttribute("Estado") == "Activo") {
			return true;
		} else {
			return false;
		}
	}

	// Este metodo escucha la URL localhost:8080/NOMBRE_APP/login si la misma es
	// invocada por metodo http GET
	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto con key 'datosLogin' para que el mismo sea
		// asociado
		// al model attribute del form que esta definido en la vista 'login'
		modelo.put("datosLogin", new DatosLogin());
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando
		// el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma dentro del modelo
		return new ModelAndView("login", modelo);
	}

	// Este metodo escucha la URL validar-login siempre y cuando se invoque con
	// metodo http POST
	// El metodo recibe un objeto Usuario el que tiene los datos ingresados en el
	// form correspondiente y se corresponde con el modelAttribute definido en el
	// tag form:form
	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("datosLogin") DatosLogin datosLogin, HttpServletRequest request){
		ModelMap model = new ModelMap();
		Usuario usuarioBuscado;
		
		if(datosLogin.getEmail() == "" || datosLogin.getPassword() == "") {
			model.put("error", "No se ingresaron datos para realizar login");
			return new ModelAndView("redirect:/login");
		}
		
		try {
			usuarioBuscado = servicioLogin.validarUsuario(datosLogin);
			
			if (usuarioBuscado != null) {
				model.put("usuario", usuarioBuscado);
				request.getSession().setAttribute("Estado", "Activo");
				request.getSession().setAttribute("idUsuario", usuarioBuscado.getId());
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			model.put("error", "Mail inexistente");
			return new ModelAndView("redirect:/login");
			
		} catch (UsuarioLoginException e) {
			e.printStackTrace();
			model.put("error", "Usuario o clave incorrecta");
			return new ModelAndView("redirect:/login");
		}
		return new ModelAndView("redirect:/login-index");
	}

	@RequestMapping(path = "/logout", method = RequestMethod.GET)
    public ModelAndView cerrarSesion(){
        request.getSession().invalidate();
        return new ModelAndView("redirect:/login");
    }

	@RequestMapping(path = "/saludo", method = RequestMethod.GET)
	public ModelAndView irASaludo() {
		return new ModelAndView("usuarioInicio");
	}
	
	@RequestMapping(path = "/login-index", method = RequestMethod.GET)
	public ModelAndView usuarioInicio() {
		return new ModelAndView("usuarioInicio");
	}
}