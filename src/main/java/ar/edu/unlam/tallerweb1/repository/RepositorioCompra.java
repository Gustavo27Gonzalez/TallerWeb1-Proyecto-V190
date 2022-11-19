package ar.edu.unlam.tallerweb1.repository;

import java.util.List;

import ar.edu.unlam.tallerweb1.models.compra.Compra;

public interface RepositorioCompra {
	List<Compra> listarCompras();
	void guardarCompra(Compra compra);
	Compra findCompraById(Compra compra);
}
