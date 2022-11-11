package ar.edu.unlam.tallerweb1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosRifa;
import ar.edu.unlam.tallerweb1.service.ServicioRifa;

@Controller
public class ControladorRifa {

	private ServicioRifa servicioRifa;

	@Autowired
	public ControladorRifa(ServicioRifa servicioRifa) {
		this.servicioRifa = servicioRifa;
	}

	public ModelAndView obtenerPorIdSorteo(Long idSorteo) {
		List<DatosRifa> rifas = this.servicioRifa.obtenerPorIdSorteo(idSorteo);
		ModelMap m = new ModelMap();
		m.put("rifas", rifas);
		ModelAndView mav = new ModelAndView("ver-rifas", m);
		return mav;
	}
	
	

}
