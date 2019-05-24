package fincaV1.server.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fincaV1.server.entity.VecinoBean;

@Repository
public class IncidenciaDaoImp implements IncidenciaDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Integer> incidenciacount() {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.createQuery("SELECT count(id) from IncidenciaBean where atendido='n'").getResultList();
	}

}
