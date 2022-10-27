package ar.edu.unlam.tallerweb1.service.serviceImpl;

import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosCompra;
import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.repository.RepositorioCompra;
import ar.edu.unlam.tallerweb1.repository.RepositorioSorteo;
import ar.edu.unlam.tallerweb1.service.ServicioSorteo;

@Service("servicioSorteo")
@Transactional
public class ServicioSorteoImpl implements ServicioSorteo {

    RepositorioSorteo sorteoRepository;
    
    RepositorioCompra compraRepository;
    
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
	public Boolean participar(Sorteo nuevoSorteo, Usuario usuarioParticipante, List rifas) {
		Rifa rifa = new Rifa((long)1);
		DatosCompra datos = new DatosCompra(rifa, usuarioParticipante);
		nuevoSorteo.setCantidadRifas(nuevoSorteo.getCantidadRifas()-rifas.size());
		//Compra compraRifa = new Compra();
		
		return nuevoSorteo.getCantidadRifas().equals(7);
	}

	@Override
	public Sorteo obtenerDatosDelSorteo(Sorteo sorteo) {
		return this.sorteoRepository.obtenerSorteo(sorteo);
	}

	@Override
	public void comprar(DatosCompra datosCompra) {
		Compra nuevaCompra = new Compra(datosCompra);
        compraRepository.guardar(nuevaCompra);	
	}

	
	
}