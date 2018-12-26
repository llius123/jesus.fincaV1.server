package fincaV1.server.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fincaV1.server.entity.VecinoBean;
import fincaV1.server.helper.Helper;

@Repository
public class VecinoDaoImp implements VecinoDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	Helper helper;

	public List<VecinoBean> login(String user, String pass) {

		Session currentSession = sessionFactory.getCurrentSession();
		Query<VecinoBean> theQuery = currentSession.createQuery("from VecinoBean WHERE login = :login and pass = :pass", VecinoBean.class);
		theQuery.setParameter("login", user);
		theQuery.setParameter("pass", pass);
		List<VecinoBean> vecino = theQuery.getResultList();
		return vecino;
	}

}
