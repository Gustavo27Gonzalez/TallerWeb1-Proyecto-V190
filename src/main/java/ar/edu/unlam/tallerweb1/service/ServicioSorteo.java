package ar.edu.unlam.tallerweb1.service;

import java.util.List;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;

public interface ServicioSorteo {
	void crear(DatosSorteo datosSorteo);
	void modificar(Sorteo sorteo);
	Sorteo buscarPorId(Long id);
	List<Sorteo> listarSorteos();
	Boolean participar(Sorteo nuevoSorteo, Usuario usuarioParticipante, List<Rifa> rifas);
	Usuario obtenerGanador(Sorteo sorteo);
	List<Usuario> listarParticipantes(Sorteo sorteo);
}