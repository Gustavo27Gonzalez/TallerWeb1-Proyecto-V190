package ar.edu.unlam.tallerweb1.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.models.enums.TipoAlgoritmo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.service.SessionService;

import ar.edu.unlam.tallerweb1.service.serviceImpl.ServicioMercadoPagoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.service.ServicioRifa;
import ar.edu.unlam.tallerweb1.service.ServicioSorteo;

@Controller
public class ControladorSorteo {

	ServicioSorteo servicioSorteo;
	ServicioRifa servicioRifa;
	SessionService sessionService;
	ServicioMercadoPagoImpl servicioMercadoPago;
	
	private List<Sorteo> sorteos;
	
	@Autowired
	public ControladorSorteo(ServicioSorteo servicioSorteo, ServicioRifa servicioRifa, SessionService sessionService, ServicioMercadoPagoImpl servicioMercadoPago) {
		this.servicioSorteo = servicioSorteo;
		this.servicioRifa = servicioRifa;
		this.sessionService = sessionService;
		this.servicioMercadoPago = servicioMercadoPago;
	}

	@RequestMapping(path="/listado-sorteos", method = RequestMethod.GET)
	public ModelAndView listarSorteos() {
		ModelMap model = new ModelMap();
		List<Sorteo> sorteos = this.servicioSorteo.listarSorteos();
		model.put("sorteos", sorteos);
		ModelAndView mav = new ModelAndView("listar-sorteos", model);
		return mav;
	}

	@RequestMapping(path="/validar-comprar-rifa", method = RequestMethod.POST)
	public ModelAndView participarSorteo(@ModelAttribute("sorteo") DatosSorteo datosSorteo) {
		ModelMap model = new ModelMap();
		model.put("datosSorteo", datosSorteo);
		ModelAndView mav = new ModelAndView("participar", model);
		return mav;
	}


	@RequestMapping(path="/seleccionar-sorteo", method = RequestMethod.GET)
	public ModelAndView seleccionarSorteo(@RequestParam("id") long id) {
		this.sessionService.setCurrentSorteo(this.servicioSorteo.getSorteo(id));
		ModelMap model = new ModelMap();
		model.put("sorteo", this.servicioSorteo.getSorteo(id));
//
//		// Add Your credentials
//		MercadoPagoConfig.setAccessToken("TEST-4642931363993034-113021-0ebf4b359b221f5dd62a6c87b90322bb-181683199");
//
//// Create a preference object
//		PreferenceClient client = new PreferenceClient();
//
//// Create a preference item
//		List<PreferenceItemRequest> items = new ArrayList<>();
//		PreferenceItemRequest item =
//				PreferenceItemRequest.builder()
//						.title("Meu produto")
//						.quantity(1)
//						.unitPrice(new BigDecimal("100"))
//						.build();
//		items.add(item);
//
//		PreferenceRequest request = PreferenceRequest.builder().items(items).build();
//
//		client.create(request);
		ModelAndView mav = new ModelAndView("participar", model);
		return mav;
	}

	@RequestMapping(path="/comprar")
	public ModelAndView comprar() throws Exception {
		ModelMap model = new ModelMap();
		Sorteo sorteo = this.sessionService.getCurrentSorteo();
		Usuario usuario = this.sessionService.getCurrentUser();
		if (sorteo.getCantidadRifasVendidas() < sorteo.getCantidadRifas()) {
			Rifa rifa = new Rifa();
			rifa.setSorteo(sorteo);
			rifa.setUsuario(usuario.getId());
			sorteo.setCantidadRifasVendidas(sorteo.getCantidadRifasVendidas() + 1);
			this.servicioSorteo.modificar(sorteo);
			this.servicioRifa.crearRifa(rifa);
			model.put("sorteo", sorteo);
			model.put("rifa", rifa);
			model.put("usuario", usuario);
			ModelAndView mav = new ModelAndView("compra-exitosa", model);
			return mav;
		} else {
			model.put("sorteo", sorteo);
			model.put("usuario", usuario);
			ModelAndView mav = new ModelAndView("sorteo-completo", model);
			return mav;
		}
	}

	//deprecatedcrearSorteo
	@RequestMapping(path="/sortear", method = RequestMethod.GET)
    public ModelAndView sortearGanador(@RequestParam("id") long id) {
		ModelMap model = new ModelMap();
		Sorteo sorteo = this.servicioSorteo.getSorteo(id);
		Usuario ganador = this.servicioSorteo.obtenerUsuarioGanador(sorteo);
		model.put("ganador", ganador);
		ModelAndView mav = new ModelAndView("ganador", model);
		return mav;
    }

	@RequestMapping(path="/mis-sorteos", method = RequestMethod.GET)
	public ModelAndView listarMisSorteos() throws Exception {
		ModelMap model = new ModelMap();
		Usuario actual = this.sessionService.getCurrentUser();
		List<Sorteo> sorteos = this.servicioSorteo.listarMisSorteos(actual.getId());
		model.put("sorteos", sorteos);
		ModelAndView mav = new ModelAndView("listar-mis-sorteos", model);
		return mav;
	}
}