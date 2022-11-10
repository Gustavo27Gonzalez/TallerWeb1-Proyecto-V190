package ar.edu.unlam.tallerweb1.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.controller.dtos.CompraDTO;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.repository.RepositorioCompra;
import ar.edu.unlam.tallerweb1.repository.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.service.ServicioCompra;

@Service
public class ServicioCompraImpl implements ServicioCompra{
	
	private RepositorioCompra repositorioCompra;
	private RepositorioUsuario repositorioUsuario;
	
	@Autowired
	public ServicioCompraImpl(RepositorioCompra repositorioCompra,RepositorioUsuario repositorioUsuario) {
		this.repositorioCompra = repositorioCompra;
		this.repositorioUsuario = repositorioUsuario;
	}

	@Override
	public List<CompraDTO> listarMisCompras() {
		List<CompraDTO> response = new ArrayList<>();
		List<Compra> lista = this.repositorioCompra.listarCompras();
		for(int i=0; i<lista.size(); i++) {
			CompraDTO dto = new CompraDTO();
			dto.setId(lista.get(i).getId());
			Usuario usuario = lista.get(i).getUsuario();
			Usuario buscado = this.repositorioUsuario.buscarPorEmail("admin@admin.com");
			dto.setNombreUsuario(buscado.getNombre());
			dto.setNumeroDeRifa(lista.get(i).getRifa().getId());
			response.add(dto);
		}
		return response;
	}
	
}
