package ar.edu.unlam.tallerweb1.repository.repositoryImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.repository.RepositorioCompra;

@Transactional
@Repository("repositorioCompra")
public class RepositorioCompraImpl implements RepositorioCompra{
	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioCompraImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Compra> listarCompras() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Compra.class)
				.list();
	}
}
