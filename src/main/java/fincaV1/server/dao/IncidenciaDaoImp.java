package fincaV1.server.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fincaV1.server.entity.IncidenciaBean;

@Repository
public class IncidenciaDaoImp implements IncidenciaDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<IncidenciaBean> testApi() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by last name
		Query<IncidenciaBean> theQuery = currentSession.createQuery(" from IncidenciaBean", IncidenciaBean.class);

		// execute query and get result list
		List<IncidenciaBean> incidencia = theQuery.getResultList();
		
		return incidencia;
	}

}
