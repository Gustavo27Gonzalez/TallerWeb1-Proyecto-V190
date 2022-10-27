package ar.edu.unlam.tallerweb1.repository;

import java.util.List;

import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;

public interface RepositorioCompra {

	void guardar(Compra nuevaCompra);

	List<Compra> listarCompras();

	

}
