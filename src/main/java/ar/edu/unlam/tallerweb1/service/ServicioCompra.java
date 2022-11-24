package ar.edu.unlam.tallerweb1.service;

import java.util.List;

import ar.edu.unlam.tallerweb1.controller.dtos.CompraDTO;
import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import exceptions.RifaNoDisponibleException;

public interface ServicioCompra {
	List<CompraDTO> listarMisCompras();
	void comprar(Rifa rifa, Usuario usuario) throws RifaNoDisponibleException;
	List<Compra> getComprasSorteo(Long sorteoId);
}
