package ar.edu.unlam.tallerweb1.repository.repositoryImpl;

import java.util.List;

import ar.edu.unlam.tallerweb1.models.usuarios.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.repository.RepositorioSorteo;

@Repository("repositorioSorteo")
public class RepositorioSorteoImpl implements RepositorioSorteo {

	@Autowired
	SessionFactory sessionFactory;

    @Autowired
	public RepositorioSorteoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
    
	@Override
	public void crear(Sorteo sorteo) {
		sessionFactory.getCurrentSession().save(sorteo);

	}

	@Override
	public void modificar(Sorteo sorteo) {
		sessionFactory.getCurrentSession().update(sorteo);
	}

	@Override
	public Sorteo buscarSorteoPorId(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		return (Sorteo) session.createCriteria(Sorteo.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public List<Sorteo> listarSorteos() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Sorteo.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.list();
	}


	@Override
	public List<Sorteo> buscarSorteosConRifasDisponibles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sorteo> listarMisSorteos(Long idCreador) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Sorteo.class)
				.add( Restrictions.eq("idCreador", idCreador))
				.list();
	}

}