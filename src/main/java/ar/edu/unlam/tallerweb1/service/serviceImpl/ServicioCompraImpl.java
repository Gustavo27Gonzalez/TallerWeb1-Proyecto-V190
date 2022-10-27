package ar.edu.unlam.tallerweb1.service.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.repository.RepositorioCompra;
import ar.edu.unlam.tallerweb1.repository.RepositorioSorteo;
import ar.edu.unlam.tallerweb1.service.ServicioCompra;

@Service("servicioCompra")
@Transactional
public class ServicioCompraImpl implements ServicioCompra {

    
    RepositorioCompra compraRepository;
    
    @Autowired
    public ServicioCompraImpl(RepositorioCompra compraRepository){
        this.compraRepository = compraRepository;
        
    }
	@Override
	public List<Compra> listarCompras() {
		return this.compraRepository.listarCompras();
	}
	@Override
	public void crear(Compra compra) {
		this.compraRepository.guardar(compra);
	}

}
