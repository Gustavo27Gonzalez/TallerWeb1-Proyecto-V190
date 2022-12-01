package ar.edu.unlam.tallerweb1.repository.repositoryImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.models.compra.Compra;
import ar.edu.unlam.tallerweb1.models.rifas.Rifa;
import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
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
	public void comprar(Rifa rifa) {
		this.sessionFactory.getCurrentSession().save(rifa);
	}

	@Override
	public Compra comprar(Compra compra) {
		return (Compra)this.sessionFactory.getCurrentSession().save(compra);
	}

	@Override
	public Rifa getRifaById(Long id) {
		return (Rifa) sessionFactory.getCurrentSession().createCriteria(Rifa.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public void guardarRifa(Rifa rifa) {
		this.sessionFactory.getCurrentSession().save(rifa);
	}

	@Override
	public List<Rifa> listarMisRifas(Long id) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Compra.class)
				.add( Restrictions.eq("usuario_id", id))
				.list();
	}

}
