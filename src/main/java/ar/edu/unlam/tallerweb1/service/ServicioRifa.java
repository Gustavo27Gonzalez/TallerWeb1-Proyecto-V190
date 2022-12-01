package ar.edu.unlam.tallerweb1.service;

import java.util.List;

import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;

public interface ServicioRifa {

	List<Rifa> listarRifas();
	Compra comprarRifa(Compra compraRifa);
	void crearRifa(Rifa rifa);

}
