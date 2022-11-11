package ar.edu.unlam.tallerweb1.service;

import java.util.List;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosRifa;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;

public interface ServicioRifa {

	List<Rifa> listarRifas();

	List<DatosRifa> obtenerPorIdSorteo(Long idSorteo);
	
}
