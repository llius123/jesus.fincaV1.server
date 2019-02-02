package fincaV1.server.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fincaV1.server.dao.FacturaProveedorDaoImp;
import fincaV1.server.entity.FacturaProveedorBean;

@Service
public class FacturaProveedorServiceImp {
	
	@Autowired
	FacturaProveedorDaoImp facturaProveedorDaoImp;

	@Transactional
	public List<FacturaProveedorBean> facturaFiltroFecha(String desde, String hasta){
		return facturaProveedorDaoImp.facturaFiltroFecha(desde, hasta);
	};
	
	@Transactional
	public List<FacturaProveedorBean> facturaFiltroGeneral(String tabla, String dato){
		return facturaProveedorDaoImp.facturaFiltroGeneral(tabla, dato);
	}
}
