package fincaV1.server.daogeneric;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class GenericDaoImp implements GenericDao {

	@Autowired
	private SessionFactory sessionFactory;

	public <T> T getAll(final Class<T> type) {
		Session session = sessionFactory.getCurrentSession();
		return (T) session.createQuery("FROM  " + type.getSimpleName()).getResultList();			
	}

	public <T> T get(final Class<T> type, final Long id) {
		return (T) sessionFactory.getCurrentSession().get(type, id);
	}

	public <T> String saveOrUpdate(final T o) {
		sessionFactory.getCurrentSession().saveOrUpdate(o);
		return "Registro creado o updateado";
	}

	public <T> String delete(final T o) {
		sessionFactory.getCurrentSession().delete(o);
		return "Registro eliminado";
	}
	
}
