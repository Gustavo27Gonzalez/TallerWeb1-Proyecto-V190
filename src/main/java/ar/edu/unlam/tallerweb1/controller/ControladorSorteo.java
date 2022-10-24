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
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
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
		ModelMap model = new ModelMap();
		List<Sorteo> sorteos = this.servicioSorteo.listarSorteos();
		model.put("sorteos", sorteos);
		ModelAndView mav = new ModelAndView("listar-sorteos", model);
		return mav;
	}

	@RequestMapping(path="/participar", method = RequestMethod.GET)
	public ModelAndView participar() {
		ModelMap model = new ModelMap();
		//this.servicioSorteo.participar(sorteo, usuario, rifa);
		return new ModelAndView("participar");
	}
	
	@RequestMapping(path="/listado-participantes")
	public ModelAndView listarParticipantes(Sorteo sorteo) {
		ModelMap model = new ModelMap();
		List<Usuario> participantes = this.servicioSorteo.listarParticipantes(sorteo);
		model.put("participantes", participantes);
		ModelAndView mav = new ModelAndView("listar-participantes", model);
		return mav;
	}

	@RequestMapping(path="/ganador", method = RequestMethod.GET)
	public ModelAndView obtenerGanador() {
		ModelMap model = new ModelMap();
		//Usuario ganador = this.servicioSorteo.obtenerGanador();
		//model.put("ganador", ganador);
		ModelAndView mav = new ModelAndView("ganador", model);
		return mav;
	}

	@RequestMapping(path="/listado-rifas")
	public ModelAndView listarRifas(Sorteo sorteo) {
		ModelMap model = new ModelMap();
		List<Rifa> rifas = this.servicioSorteo.listarRifas(sorteo);
		model.put("rifas", rifas);
		ModelAndView mav = new ModelAndView("listar-rifas", model);
		return mav;
	}
	
	public ModelAndView sorteoInfo(Sorteo sorteo){
		return new ModelAndView("redirect:/listado-rifas");
	}

}