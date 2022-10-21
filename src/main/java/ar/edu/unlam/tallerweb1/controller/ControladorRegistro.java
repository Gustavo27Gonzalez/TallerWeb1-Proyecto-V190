package ar.edu.unlam.tallerweb1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosRegistro;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.service.ServicioLogin;
import ar.edu.unlam.tallerweb1.service.ServicioUsuario;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorRegistro {
	
    ServicioUsuario servicioUsuario;

    @Autowired
    public ControladorRegistro(ServicioUsuario servicioUsuario){
        this.servicioUsuario = servicioUsuario;
    }

    @RequestMapping(path="/registrar-usuario", method = RequestMethod.GET)
    public ModelAndView mostrarFormularioDeRegistro(){
        ModelMap model = new ModelMap();
        model.put("datosRegistro", new DatosRegistro());
        return new ModelAndView("registro-usuario", model);
    }

    @RequestMapping(path="/registrar-usuario", method = RequestMethod.POST)
    public ModelAndView registrar(@ModelAttribute("datosRegistro") DatosRegistro datosRegistro) {
        ModelMap model = new ModelMap();
        try{
            servicioUsuario.registrar(datosRegistro);
        }catch(RuntimeException e){
            e.printStackTrace();
        }
        return new ModelAndView("redirect:/login");
    }


    private ModelAndView registroFallido(ModelMap model, String mensaje){
        model.put("error", mensaje);
        return new ModelAndView("registrar-usuario", model);
    }
    

}