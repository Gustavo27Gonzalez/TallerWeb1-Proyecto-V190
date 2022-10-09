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

import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.service.ServicioLogin;
import ar.edu.unlam.tallerweb1.service.ServicioSorteo;

@Controller
public class ControladorSorteo {
	
	@Autowired
	ServicioSorteo servicioSorteo;
	
	private List<Sorteo> sorteos;
	
	@Autowired
	public ControladorSorteo(ServicioSorteo servicioSorteo) {
		this.servicioSorteo = servicioSorteo;
	}

	@RequestMapping(path="/listado-sorteos", method = RequestMethod.GET)
	public ModelAndView listarSorteos() {
		List<Sorteo> listaSorteos = this.servicioSorteo.listarSorteos();
		ModelMap model = new ModelMap();
		model.put("sorteos", listaSorteos);
		return new ModelAndView("listar-sorteos", model);
	}

}
