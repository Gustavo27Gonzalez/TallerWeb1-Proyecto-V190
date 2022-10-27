package ar.edu.unlam.tallerweb1.service;

import java.util.List;

import ar.edu.unlam.tallerweb1.models.compra.Compra;

public interface ServicioCompra {

	void crear(Compra compra);
	List<Compra> listarCompras();

}
