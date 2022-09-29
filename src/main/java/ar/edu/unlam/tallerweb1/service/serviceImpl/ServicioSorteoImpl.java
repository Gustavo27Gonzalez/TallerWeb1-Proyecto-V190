package ar.edu.unlam.tallerweb1.service.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.controller.dtos.DatosSorteo;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.repository.RepositorioSorteo;
import ar.edu.unlam.tallerweb1.service.ServicioSorteo;

@Service("servicioSorteo")
@Transactional
public class ServicioSorteoImpl implements ServicioSorteo {

	@Autowired
    RepositorioSorteo repositorioSorteo;
    
    @Autowired
    public ServicioSorteoImpl(RepositorioSorteo servicioSorteoDao){
        this.repositorioSorteo = servicioSorteoDao;
    }
	
	@Override
	public Sorteo registrar(DatosSorteo datosSorteo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sorteo buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sorteo> listarSorteos() {
		// TODO Auto-generated method stub
		return null;
	}

}
