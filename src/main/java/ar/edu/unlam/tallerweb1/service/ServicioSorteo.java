package ar.edu.unlam.tallerweb1.service;

import java.util.List;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;

public interface ServicioSorteo {
	void crear(DatosSorteo datosSorteo);
	void modificar(Sorteo sorteo);
	Sorteo buscarPorId(Integer id);
	List<Sorteo> listarSorteos();
}
