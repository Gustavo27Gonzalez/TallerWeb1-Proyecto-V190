package ar.edu.unlam.tallerweb1.repository.repositoryImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.models.sorteos.Sorteo;
import ar.edu.unlam.tallerweb1.repository.RepositorioSorteo;

@Repository("sorteoRepository")
public class RepositorioSorteoImpl implements RepositorioSorteo {

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Sorteo buscarSorteoPorId(Long id) {
		return (Sorteo) sessionFactory.getCurrentSession().createCriteria(Sorteo.class)
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
	public List<Sorteo> buscarSorteosPorPremio(String premio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sorteo> buscarSorteosPorPrecioRifa(Double precio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sorteo> buscarSorteosConRifasDisponibles() {
		// TODO Auto-generated method stub
		return null;
	}

}
