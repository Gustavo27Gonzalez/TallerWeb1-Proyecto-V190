package ar.edu.unlam.tallerweb1.repository;

import java.util.List;

import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;

public interface RepositorioRifa {

	List<Rifa> listarRifas();
	Compra comprar(Compra compra);
}
