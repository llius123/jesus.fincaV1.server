package fincaV1.server.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.sql.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fincaV1.server.entity.FacturaProveedorBean;

@Repository
public class FacturaProveedorDaoImp {

	@Autowired
	private SessionFactory sessionFactory;

	public List<FacturaProveedorBean> facturaFiltroFecha(String desde, String hasta) {
		Session currentSession = sessionFactory.getCurrentSession();
//		String qry = "select * from factura_proveedor where ";
//		SQLQuery sqlQuery = currentSession.createSQLQuery(qry);
//
//		sqlQuery.addEntity(FacturaProveedorBean.class);
//
//		List<FacturaProveedorBean> list = sqlQuery.list();

		Query query = currentSession.createSQLQuery("select * from `factura_proveedor` where fecha_registro BETWEEN :desde AND :hasta")
				.addEntity(FacturaProveedorBean.class)
				.setParameter("desde", desde)
				.setParameter("hasta", hasta);
		List<FacturaProveedorBean> list = query.list();
		return list;
	}
	
	public List<FacturaProveedorBean> facturaFiltroGeneral(String tabla, String dato){
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createSQLQuery("select * from `factura_proveedor` where " + tabla + " = " + "'"+dato+"'")
				.addEntity(FacturaProveedorBean.class);
		System.err.println(query.toString());
		System.err.print(query.toString());
		List<FacturaProveedorBean> list = query.list();
		return list;
	}
}
