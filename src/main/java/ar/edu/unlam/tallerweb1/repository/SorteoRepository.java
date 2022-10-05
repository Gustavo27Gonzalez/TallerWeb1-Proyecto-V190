package ar.edu.unlam.tallerweb1.repository;

import java.util.List;

import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;

public interface SorteoRepository {
	void crear(Sorteo sorteo);
	Sorteo buscarPorId(Integer idSorteo);
	void modificar(Sorteo sorteo);
	List <Sorteo> listarSorteos();
	List <Sorteo> buscarSorteosPorPremio(String premio);
	List <Sorteo> buscarSorteosPorPrecioRifa(Double precio);
	List <Sorteo> buscarSorteosConRifasDisponibles();
	// Pensar Qu� otros m�todos implementar
}
