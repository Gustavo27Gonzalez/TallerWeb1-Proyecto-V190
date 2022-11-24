package ar.edu.unlam.tallerweb1.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosRegistro;
import exceptions.RifaNoDisponibleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		//String email = req.getSession().getAttribute("email");
		ModelMap model = new ModelMap();
		List<CompraDTO> lista = this.servicioCompra.listarMisCompras();
		if (lista.size() > 0) {
			model.put("compras", lista);
			model.put("msj", "Compra correcta");
			return new ModelAndView("ver-compras", model);
		}else {
			model.put("ERROR", "Rifa no diponible");
			return new ModelAndView("ver-compras", model);
		}
	}

	@RequestMapping(path = "/comprar", method = RequestMethod.POST)
	public ModelAndView comprarRifa(@ModelAttribute("rifa") Rifa rifa) throws RifaNoDisponibleException {
		Usuario usuario = new Usuario(1L, "Agustin", "admin@admin.com", Boolean.FALSE);
		this.servicioCompra.comprar(rifa,usuario);
		return new ModelAndView("ver-compras");
	}
}
