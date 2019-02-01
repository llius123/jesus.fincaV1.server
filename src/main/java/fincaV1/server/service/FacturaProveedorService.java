package fincaV1.server.service;

import java.sql.Date;
import java.util.List;

import fincaV1.server.entity.FacturaProveedorBean;

public interface FacturaProveedorService {
	
	public List<FacturaProveedorBean> facturaFiltroFecha(String desde, String hasta);
	
	public List<FacturaProveedorBean> facturaFiltroGeneral(String tabla, Integer dato);

}
