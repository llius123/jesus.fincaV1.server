package fincaV1.server.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class GenericDaoImp implements GenericDao {

	@Autowired
	private SessionFactory sessionFactory;

	//Revisar que pasa cuando sea el resultado null
	public <T> T getAll(final Class<T> type) {
		Session session = sessionFactory.getCurrentSession();
		return (T) session.createQuery("FROM  " + type.getSimpleName()).getResultList();			
	}

	public <T> T get(final Class<T> type, final Long id) {
		return (T) sessionFactory.getCurrentSession().get(type, id);
	}

	public <T> void saveOrUpdate(final T o) {
		sessionFactory.getCurrentSession().saveOrUpdate(o);
	}

	//Revisar que pasa cuando sea el resultado null
	public <T> T save(final T o) {
		return (T) sessionFactory.getCurrentSession().save(o);
	}

	public void delete(final Object object) {
		sessionFactory.getCurrentSession().delete(object);
	}
	
}
