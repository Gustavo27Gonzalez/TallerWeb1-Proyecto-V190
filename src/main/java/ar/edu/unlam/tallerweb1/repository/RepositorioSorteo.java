package ar.edu.unlam.tallerweb1.repository;

import java.util.List;

import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;

public interface RepositorioSorteo {
	
	void crear(Sorteo sorteo);
	void modificar(Sorteo sorteo);
    Sorteo buscarSorteoPorId(Long id);
	List <Sorteo> listarSorteos();
	List <Sorteo> buscarSorteosPorPremio(String premio);
	List <Sorteo> buscarSorteosPorPrecioRifa(Double precio);
	List <Sorteo> buscarSorteosConRifasDisponibles();
	List<Usuario> listarParticipantes(Sorteo sorteo);
}