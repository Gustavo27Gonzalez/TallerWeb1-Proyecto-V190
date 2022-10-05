package ar.edu.unlam.tallerweb1.service.serviceImpl;

import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
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
		// TODO Auto-generated method stub
		
	}

	@Override
    public List<Sorteo> listarSorteos() {
        List<Sorteo> sorteos = new LinkedList<Sorteo>();
        for (int i = 0; i < 5; i++) {
            sorteos.add(new Sorteo());
        }
        return sorteos;
    }

}