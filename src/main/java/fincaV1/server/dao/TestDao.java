package fincaV1.server.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private GenericDao genericDao;
	
	public <T> T getall(final Class<T> type) {
		return genericDao.getAll(type);
	}
	
	public <T> T get(final Class<T> type,final Long id) {
		return genericDao.get(type, id);
	}

}
