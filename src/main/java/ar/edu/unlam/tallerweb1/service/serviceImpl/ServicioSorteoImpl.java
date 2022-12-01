package ar.edu.unlam.tallerweb1.service.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import ar.edu.unlam.tallerweb1.repository.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosCompra;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.repository.RepositorioRifa;
import ar.edu.unlam.tallerweb1.repository.RepositorioSorteo;
import ar.edu.unlam.tallerweb1.service.ServicioSorteo;

@Service("servicioSorteo")
@Transactional
public class ServicioSorteoImpl implements ServicioSorteo {

    RepositorioSorteo sorteoRepository;
    RepositorioRifa rifaRepository;
    ServicioAlgoritmo servicioAlgoritmo;
	RepositorioUsuario repositorioUsuario;
    @Autowired
    public ServicioSorteoImpl(RepositorioSorteo sorteoRepository, RepositorioUsuario repositorioUsuario, RepositorioRifa rifaRepository) {
        this.sorteoRepository = sorteoRepository;
		this.servicioAlgoritmo = new ServicioAlgoritmo();
		this.repositorioUsuario = repositorioUsuario;
		this.rifaRepository = rifaRepository;
    }
	
	@Override
	public void crear(DatosSorteo datosSorteo, Usuario creador) {
		Sorteo nuevoSorteo = new Sorteo(datosSorteo, creador.getId());
		sorteoRepository.crear(nuevoSorteo);
	}

	@Override
	public Sorteo buscarPorId(Long id) {
		return this.sorteoRepository.buscarSorteoPorId(id);
	}

	@Override
	public void modificar(Sorteo sorteo) {
		this.sorteoRepository.modificar(sorteo);
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
		List<Rifa> rifas = this.sorteoRepository.getRifas(sorteo);
		this.servicioAlgoritmo.setTipo(sorteo.getAlgoritmo());
		Rifa ganador = this.servicioAlgoritmo.getGanador(rifas);
		return this.repositorioUsuario.buscarId(ganador.getUsuario());
	}

	@Override
	public List<Sorteo> listarMisSorteos(Long idUsuario) {
		List<Sorteo> misSorteos = this.sorteoRepository.listarMisSorteos(idUsuario);
		return misSorteos;
  }
  
	public Sorteo getSorteo(long sorteo) {
		return this.sorteoRepository.buscarSorteoPorId(sorteo);
	}

	@Override
	public void cerrarSorteo(Sorteo sorteo) {
		this.sorteoRepository.elimnar(sorteo);
	}

	@Override
	public Boolean participar(Sorteo nuevoSorteo, Usuario usuarioParticipante, List rifas) {
		Rifa rifa = new Rifa(50L, Boolean.TRUE, nuevoSorteo);
		DatosCompra datos = new DatosCompra(rifa, usuarioParticipante);
		nuevoSorteo.setCantidadRifas(nuevoSorteo.getCantidadRifas()-rifas.size());
		//Compra compraRifa = new Compra();
		return nuevoSorteo.getCantidadRifas().equals(7);
	}

	@Override
	public List<Sorteo> listarSorteosQueParticipo(Long id) {
		List<Sorteo> misSorteos = this.sorteoRepository.listarSorteosQueParticipo(id);
		return misSorteos;
	}

	@Override
	public List<Rifa> listarMisRifas(Long id) {
		List<Rifa> misRifas = this.rifaRepository.listarMisRifas(id);
		return misRifas;
	}

	
	
}