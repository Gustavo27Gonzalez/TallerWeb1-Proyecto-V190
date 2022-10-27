package ar.edu.unlam.tallerweb1.repository.repositoryImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.repository.RepositorioRifa;

@Repository("repositorioRifa")
public class RepositorioRifaImpl implements RepositorioRifa{
		
	SessionFactory sessionFactory;
	
	@Autowired
	public RepositorioRifaImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Rifa> listarRifas() {
		
		return sessionFactory.getCurrentSession()
                .createCriteria(Rifa.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
	}

	@Override
	public Compra comprar(Compra compra) {
		return (Compra)this.sessionFactory.getCurrentSession().save(compra);
	}


	
}
