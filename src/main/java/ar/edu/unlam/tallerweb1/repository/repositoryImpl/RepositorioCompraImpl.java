package ar.edu.unlam.tallerweb1.repository.repositoryImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.repository.RepositorioCompra;

@Repository("repositorioCompra")
public class RepositorioCompraImpl implements RepositorioCompra {

	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioCompraImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
    
	@Override
	public void guardar(Compra nuevaCompra) {
		sessionFactory.getCurrentSession().save(nuevaCompra);
	}

	@Override
	public List<Compra> listarCompras() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Compra.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.list();
	}

	

}
