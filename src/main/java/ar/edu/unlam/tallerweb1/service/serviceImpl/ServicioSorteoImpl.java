package ar.edu.unlam.tallerweb1.service.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosCompra;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.repository.RepositorioSorteo;
import ar.edu.unlam.tallerweb1.service.ServicioSorteo;

@Service("servicioSorteo")
@Transactional
public class ServicioSorteoImpl implements ServicioSorteo {

    RepositorioSorteo sorteoRepository;
    
    @Autowired
    public ServicioSorteoImpl(RepositorioSorteo sorteoRepository){
        this.sorteoRepository = sorteoRepository;
    }
	
	@Override
	public void crear(DatosSorteo datosSorteo) {
		Sorteo nuevoSorteo = new Sorteo(datosSorteo);
		sorteoRepository.crear(nuevoSorteo);
	}

	@Override
	public Sorteo buscarPorId(Long id) {
		return this.sorteoRepository.buscarSorteoPorId(id);
	}

	@Override
	public void modificar(Sorteo sorteo) {
		
	}

	@Override
    public List<Sorteo> listarSorteos() {
		return this.sorteoRepository.listarSorteos();
    }

	@Override
	public Rifa obtenerGanador(List<Rifa> rifas) {
		int ganador = (int) Math.floor(Math.random() * rifas.size());
 		return rifas.get(ganador);
	}

	@Override
	public Usuario obtenerUsuarioGanador(Sorteo sorteo) {
		// TODO
		// compra filtrar por idsorteo, return lista de compras
		// this.servicioCompraObtenerRifasPara(sorteo)
		List<Rifa> rifas = new ArrayList();
		rifas.add(new Rifa());
		rifas.add(new Rifa());
		Rifa rifa = obtenerGanador(rifas);
		// TODO
		// this.servicioCompraBuscarPropietarioDeRifa(rifa);
		Usuario ganador = new Usuario();
		ganador.setEmail("mock@mock.com");
		ganador.setNombre("Test");
		return ganador;
	}

	@Override
	public Boolean participar(Sorteo nuevoSorteo, Usuario usuarioParticipante, List rifas) {
		Rifa rifa = new Rifa(50L, Boolean.TRUE, nuevoSorteo);
		DatosCompra datos = new DatosCompra(rifa, usuarioParticipante);
		nuevoSorteo.setCantidadRifas(nuevoSorteo.getCantidadRifas()-rifas.size());
		//Compra compraRifa = new Compra();
		return nuevoSorteo.getCantidadRifas().equals(7);
	}

	
	
}