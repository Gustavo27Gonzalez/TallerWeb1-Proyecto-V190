package ar.edu.unlam.tallerweb1.service;

import java.util.List;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;

public interface ServicioSorteo {
	
	void registrar(DatosSorteo datosSorteo);
    Sorteo buscarPorId(Long id);
    List<Sorteo> listarSorteos();

}
