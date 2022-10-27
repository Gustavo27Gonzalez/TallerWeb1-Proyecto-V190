package ar.edu.unlam.tallerweb1.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.service.ServicioLogin;
import ar.edu.unlam.tallerweb1.service.ServicioRifa;
import ar.edu.unlam.tallerweb1.service.ServicioSorteo;

@Controller
public class ControladorSorteo {
	
	@Autowired
	ServicioSorteo servicioSorteo;
	@Autowired
	ServicioRifa servicioRifa;
	
	private List<Sorteo> sorteos;
	
	@Autowired
	public ControladorSorteo(ServicioSorteo servicioSorteo, ServicioRifa servicioRifa) {
		this.servicioSorteo = servicioSorteo;
		this.servicioRifa = servicioRifa;
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
		ModelAndView mav = new ModelAndView("participar", model);
		return mav;
	}
	
	
	

}