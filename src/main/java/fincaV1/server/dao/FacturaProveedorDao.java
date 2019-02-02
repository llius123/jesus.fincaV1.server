package fincaV1.server.dao;

import java.sql.Date;
import java.util.List;

import fincaV1.server.entity.FacturaProveedorBean;

public interface FacturaProveedorDao {

	public List<FacturaProveedorBean> facturaFiltroFecha(String desde, String hasta);
	
	public List<FacturaProveedorBean> facturaFiltroGeneral(String tabla, String dato);
}
