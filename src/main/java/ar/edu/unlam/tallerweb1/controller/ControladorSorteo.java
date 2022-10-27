package ar.edu.unlam.tallerweb1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosCompra;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.service.ServicioRifa;
import ar.edu.unlam.tallerweb1.service.ServicioSorteo;

@Controller
public class ControladorSorteo {
	
	@Autowired
	ServicioSorteo servicioSorteo;
	@Autowired
	ServicioRifa servicioRifa;
		
	@Autowired
	public ControladorSorteo(ServicioSorteo servicioSorteo, ServicioRifa servicioRifa) {
		this.servicioSorteo = servicioSorteo;
		this.servicioRifa = servicioRifa;
	}
	
	@RequestMapping(path="/crearSorteo", method = RequestMethod.GET)
    public ModelAndView crearSorteo() {
    	
    	ModelMap modelo = new ModelMap();
    	modelo.put("datosSorteo", new DatosSorteo());
    	
    	return new ModelAndView("crearSorteo", modelo);
    }
    
    @RequestMapping(path = "/validar-crearSorteo", method = RequestMethod.POST)
	public ModelAndView validarCrearSorteo(@ModelAttribute("datosSorteo") DatosSorteo datosSorteo, HttpServletRequest request) {
		
		try{
			servicioSorteo.crear(datosSorteo);
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

	@RequestMapping(path="/listado-sorteos", method = RequestMethod.GET)
	public ModelAndView listarSorteos() {
		ModelMap model = new ModelMap();
		List<Sorteo> sorteos = this.servicioSorteo.listarSorteos();
		model.put("sorteos", sorteos);
		ModelAndView mav = new ModelAndView("listar-sorteos", model);
		return mav;
	}

	@RequestMapping(path="/google", method = RequestMethod.GET)
	public ModelAndView participar() {
		//ModelMap model = new ModelMap();
		
		return new ModelAndView("asdas");
	}

	@RequestMapping(path="/participar", method = RequestMethod.GET)
	public ModelAndView listarRifas() {
		ModelMap model = new ModelMap();
		List<Rifa> rifas = this.servicioRifa.listarRifas();
		model.put("rifas", rifas);
		ModelAndView mav = new ModelAndView("comprarRifa", model);
		return mav;
	}
	
	
	@RequestMapping(path="/comprarRifa", method = RequestMethod.GET)
    public ModelAndView comprarRifa() {
    	
    	ModelMap modelo = new ModelMap();
    	modelo.put("datosCompra", new DatosCompra());
    	
    	return new ModelAndView("comprarRifa", modelo);
    }
    
    @RequestMapping(path = "/validar-comprarRifa", method = RequestMethod.POST)
	public ModelAndView validarComprarRifa(@ModelAttribute("datosCompra") DatosCompra datosCompra, HttpServletRequest request) {
		
		try{
			servicioSorteo.comprar(datosCompra);
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