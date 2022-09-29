package ar.edu.unlam.tallerweb1.controller;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.service.ServicioSorteo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorUsuario {
	
	@Autowired
    ServicioSorteo servicioSorteo;
	
	@Autowired
    HttpServletRequest request;
    
    @Autowired
    public ControladorUsuario(ServicioSorteo servicioSorteo, HttpServletRequest request) {
        this.servicioSorteo = servicioSorteo;
        this.request = request;
    }
    
    
    @RequestMapping(path="/crearSorteo", method = RequestMethod.GET)
    public ModelAndView crearSorteo() {
    	
    	ModelMap modelo = new ModelMap();
    	modelo.put("datosSorteo", new DatosSorteo());
    	
    	return new ModelAndView("crearSorteo", modelo);
    }
    
    @RequestMapping(path = "/validar-crearSorteo", method = RequestMethod.POST)
	public ModelAndView validarCrearSorteo(@ModelAttribute("datosSorteo") DatosSorteo datosSorteo, HttpServletRequest request) {
		ModelMap model = new ModelMap();

		try{
			servicioSorteo.registrar(datosSorteo);
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
	


}
