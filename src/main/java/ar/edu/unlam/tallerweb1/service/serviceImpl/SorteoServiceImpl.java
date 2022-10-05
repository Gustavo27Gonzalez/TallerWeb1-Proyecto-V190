package ar.edu.unlam.tallerweb1.service.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.repository.SorteoRepository;
import ar.edu.unlam.tallerweb1.service.SorteoService;

@Service("servicioSorteo")
@Transactional
public class SorteoServiceImpl implements SorteoService {

    SorteoRepository sorteoRepository;
    
    @Autowired
    public SorteoServiceImpl(SorteoRepository sorteoRepository){
        this.sorteoRepository = sorteoRepository;
    }
	
	@Override
	public void crear(DatosSorteo datosSorteo) {
		Sorteo nuevoSorteo = new Sorteo(datosSorteo);
		sorteoRepository.crear(nuevoSorteo);
	}

	@Override
	public Sorteo buscarPorId(Integer id) {
		return this.sorteoRepository.buscarPorId(id);
	}

	@Override
	public void modificar(Sorteo sorteo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Sorteo> getSorteos() {
		// TODO Auto-generated method stub
		return null;
	}

}
