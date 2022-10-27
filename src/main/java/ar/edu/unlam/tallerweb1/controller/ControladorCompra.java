package ar.edu.unlam.tallerweb1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosCompra;
import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.service.ServicioRifa;
import ar.edu.unlam.tallerweb1.service.ServicioSorteo;
import ar.edu.unlam.tallerweb1.service.ServicioUsuario;

@Controller
public class ControladorCompra {
	
	
    ServicioSorteo servicioSorteo;
	
    ServicioUsuario servicioUsuario;
	
    ServicioRifa servicioRifa;
    
    HttpServletRequest request;
    
    @Autowired
    public ControladorCompra(ServicioSorteo servicioSorteo, ServicioUsuario servicioUsuario, ServicioRifa servicioRifa) {
        this.servicioSorteo = servicioSorteo;
        this.servicioUsuario = servicioUsuario;
        this.servicioRifa = servicioRifa;
    }
    /*
    @RequestMapping(path="/compras")
	public ModelAndView listarCompras() {
		ModelMap model = new ModelMap();
		List<Compra> compras = this.servicioCompra.listarCompras();
		model.put("compras", compras);
		ModelAndView mav = new ModelAndView("lista-compras", model);
		return mav;
	}
    */
    @RequestMapping(path="/comprar", method = RequestMethod.GET)
    public ModelAndView comprar(Usuario usuario, Rifa rifa) {
    	
    	ModelMap modelo = new ModelMap();
    	modelo.put("datosCompra", new DatosCompra(rifa, usuario));
    	return new ModelAndView("comprar", modelo);
    }
    
}
