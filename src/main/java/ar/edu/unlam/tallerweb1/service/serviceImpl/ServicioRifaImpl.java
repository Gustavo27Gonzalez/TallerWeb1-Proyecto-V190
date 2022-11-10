package ar.edu.unlam.tallerweb1.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.repository.RepositorioRifa;
import ar.edu.unlam.tallerweb1.service.ServicioRifa;

@Service("servicioRifa")
@Transactional
public class ServicioRifaImpl implements ServicioRifa{
	private RepositorioRifa repositorioRifa;
	
	@Autowired
	public ServicioRifaImpl(RepositorioRifa repositorioRifa) {
		this.repositorioRifa = repositorioRifa;
	}
	
	@Override
	public List<Rifa> listarRifas() {
		return this.repositorioRifa.listarRifas();
	}

	@Override
	public Compra comprarRifa(Compra compraRifa) {
		return this.repositorioRifa.comprar(compraRifa);
	}


	
}
