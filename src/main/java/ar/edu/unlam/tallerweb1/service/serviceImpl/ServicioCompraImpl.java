package ar.edu.unlam.tallerweb1.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.controller.dtos.CompraDTO;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosCompra;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.repository.RepositorioCompra;
import ar.edu.unlam.tallerweb1.repository.RepositorioRifa;
import ar.edu.unlam.tallerweb1.repository.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.service.ServicioCompra;
import exceptions.RifaNoDisponibleException;

@Service
public class ServicioCompraImpl implements ServicioCompra{
	private RepositorioCompra repositorioCompra;
	private RepositorioUsuario repositorioUsuario;
	private RepositorioRifa repositorioRifa;
	
	@Autowired
	public ServicioCompraImpl(RepositorioCompra repositorioCompra,RepositorioUsuario repositorioUsuario, RepositorioRifa repositorioRifa) {
		this.repositorioCompra = repositorioCompra;
		this.repositorioUsuario = repositorioUsuario;
		this.repositorioRifa = repositorioRifa;
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

	@Override
	public void comprar(Rifa rifa, Usuario usuario) throws RifaNoDisponibleException {
		try {
			rifa = repositorioRifa.getRifaById(rifa.getId());
		} catch (Exception e) {
			throw new RifaNoDisponibleException("RIFA NO DISPONIBLE " + rifa.getId());
		}
		DatosCompra datosCompra = new DatosCompra(rifa, usuario);
		Compra compra = new Compra(datosCompra);
		this.repositorioCompra.guardarCompra(compra);
	}

	@Override
	public List<Compra> getComprasSorteo(Long sorteoId) {
		return this.repositorioCompra.findComprasDeSorteo(sorteoId);
	}

}
