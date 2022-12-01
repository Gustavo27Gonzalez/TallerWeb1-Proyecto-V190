package ar.edu.unlam.tallerweb1.controller;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosCompra;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.enums.TipoAlgoritmo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.service.ServicioSorteo;
import ar.edu.unlam.tallerweb1.service.ServicioUsuario;

import ar.edu.unlam.tallerweb1.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorUsuario {
    ServicioSorteo servicioSorteo;
    ServicioUsuario servicioUsuario;
    HttpServletRequest request;
    SessionService sessionService;
    
    @Autowired
    public ControladorUsuario(ServicioSorteo servicioSorteo, ServicioUsuario servicioUsuario, SessionService sessionService) {
        this.servicioSorteo = servicioSorteo;
        this.servicioUsuario = servicioUsuario;
        this.sessionService = sessionService;
    }
    
    public ControladorUsuario(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }
    
    
    @RequestMapping(path="/crearSorteo", method = RequestMethod.GET)
    public ModelAndView crearSorteo() {
    	ModelMap modelo = new ModelMap();
    	modelo.put("datosSorteo", new DatosSorteo());
        modelo.put("algoritmos", TipoAlgoritmo.values());
    	return new ModelAndView("crearSorteo", modelo);
    }
    
    @RequestMapping(path = "/validar-crearSorteo", method = RequestMethod.POST)
	public ModelAndView validarCrearSorteo(@ModelAttribute("datosSorteo") DatosSorteo datosSorteo, HttpServletRequest request) throws Exception {
		ModelMap model = new ModelMap();
        Usuario usuario = sessionService.getCurrentUser();
		try{
			servicioSorteo.crear(datosSorteo, usuario);
        }catch(RuntimeException e){
            e.printStackTrace();
        }
        return sorteoCreadoExitosamente();
    }

    private ModelAndView sorteoCreadoExitosamente(){
        return new ModelAndView("redirect:/sorteoCreado");
    }
    
    @RequestMapping(path="/sorteoCreado", method = RequestMethod.GET)
    public ModelAndView sorteoCreado(){
        ModelMap model = new ModelMap();
        return new ModelAndView("sorteoCreado", model);
    }
	
    @RequestMapping(path="/listado-usuarios")
	public ModelAndView listarUsuarios() {
		ModelMap model = new ModelMap();
		List<Usuario> usuarios = this.servicioUsuario.listarUsuarios();
		model.put("usuarios", usuarios);
		ModelAndView mav = new ModelAndView("rifas-vendidas", model);
		return mav;
	}
    
    @RequestMapping(path="/comprarRifa", method = RequestMethod.GET)
    public ModelAndView comprarRifa() {
    	
    	ModelMap modelo = new ModelMap();
    	modelo.put("datosCompra", new DatosCompra());
    	
    	return new ModelAndView("comprarRifa", modelo);
    }
    
    @RequestMapping(path = "/validar-ComprarRifa", method = RequestMethod.POST)
	public ModelAndView validarComprarRifa(@ModelAttribute("datosCompra") DatosCompra datosCompra, HttpServletRequest request) {
		ModelMap model = new ModelMap();

		try{
			servicioUsuario.comprar(datosCompra);
        }catch(RuntimeException e){
            e.printStackTrace();
        }
        return rifaCompradaExitosamente();
    }

    private ModelAndView rifaCompradaExitosamente(){
        return new ModelAndView("redirect:/rifaComprada");
    }
    
    @RequestMapping(path="/rifaComprada", method = RequestMethod.GET)
    public ModelAndView rifaComprada(){
        ModelMap model = new ModelMap();
        
        return new ModelAndView("rifaComprada", model);
    }
    
   


}