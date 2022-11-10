package ar.edu.unlam.tallerweb1.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controller.dtos.CompraDTO;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.service.ServicioCompra;
import ar.edu.unlam.tallerweb1.service.ServicioRifa;

@Controller("controladorCompra")
public class ControladorCompra {
	ServicioCompra servicioCompra;
	
	@Autowired
	public ControladorCompra(ServicioCompra servicioCompra) {
		this.servicioCompra = servicioCompra;
	}

	@RequestMapping(path = "/compras", method = RequestMethod.GET)
	public ModelAndView verCompras() {
		ModelMap model = new ModelMap();
		List<CompraDTO> lista = this.servicioCompra.listarMisCompras();
		model.put("compras", lista);
		return new ModelAndView("ver-compras", model);
	}
}
