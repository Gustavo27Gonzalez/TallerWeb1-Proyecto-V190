package ar.edu.unlam.tallerweb1.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;

public class ControladorSorteo {
	
	private List<Sorteo> sorteos;

	public ControladorSorteo(int cantidadSorteos) {
		this.sorteos = new LinkedList<Sorteo>();
		for (int i = 0; i < cantidadSorteos; i++) {
			sorteos.add(new Sorteo());
		}
	}

	public ModelAndView listarSorteos() {
		ModelMap model = new ModelMap();
		model.put("sorteos", this.sorteos);
		ModelAndView mav = new ModelAndView("lista-sorteos", model);
		return mav;
	}

}
