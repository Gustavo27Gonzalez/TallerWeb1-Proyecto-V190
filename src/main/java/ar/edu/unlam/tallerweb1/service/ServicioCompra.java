package ar.edu.unlam.tallerweb1.service;

import java.util.List;

import ar.edu.unlam.tallerweb1.controller.dtos.CompraDTO;
import ar.edu.unlam.tallerweb1.models.compra.Compra;

public interface ServicioCompra {
	List<CompraDTO> listarMisCompras(String emailUsuario);
}
