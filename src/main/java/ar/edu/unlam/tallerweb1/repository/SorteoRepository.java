package ar.edu.unlam.tallerweb1.repository;

import java.util.List;

import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;

public interface SorteoRepository {
	void crear(Sorteo sorteo);
	void modificar(Sorteo sorteo);
    Sorteo buscarPorId(Integer idSorteo);
	List <Sorteo> getSorteos();
	List <Sorteo> buscarSorteosPorPremio(String premio);
	List <Sorteo> buscarSorteosPorPrecioRifa(Double precio);
	List <Sorteo> buscarSorteosConRifasDisponibles();
	// Pensar Qu� otros m�todos implementar
}
