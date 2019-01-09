package fincaV1.server.rest;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fincaV1.server.entity.FacturaProveedorBean;
import fincaV1.server.entity.ProveedorBean;
import fincaV1.server.entity.ResponseBean;
import fincaV1.server.factory.CheckForeignKey;
import fincaV1.server.servicegeneric.GenericServiceImp;

@RestController
public class ProveedorRestController {
	@Autowired
	private GenericServiceImp genericService;
	@Autowired
	private CheckForeignKey checkForeignKey;
	
	@RequestMapping(value="/proveedores", method=RequestMethod.GET)
	public List<FacturaProveedorBean> proveedors() {
		return (List<FacturaProveedorBean>) genericService.getAll(FacturaProveedorBean.class);
	}
	
	@RequestMapping(value="/proveedores/{id}", method=RequestMethod.GET)
	public ProveedorBean proveedor(@PathVariable int id) {
		return (ProveedorBean) genericService.get(ProveedorBean.class, id);
	}
	
	@RequestMapping(value="/proveedores/{id}", method=RequestMethod.DELETE)
	public ResponseBean proveedordelete(@PathVariable int id) {
		return new ResponseBean(200, genericService.delete(genericService.get(ProveedorBean.class, id)));
	}
	
	@RequestMapping(value="/proveedores", method=RequestMethod.POST)
	public <T> ResponseBean proveedorsave(@RequestBody FacturaProveedorBean facturaproveedor) {
		HashMap<T, Integer> datos = new HashMap<T, Integer>();
		datos.put((T) facturaproveedor.getProveedor(),facturaproveedor.getProveedor().getId());
		datos.put((T) facturaproveedor.getTipofactura(), facturaproveedor.getTipofactura().getId());
		datos.put((T) facturaproveedor.getComunidad(), facturaproveedor.getComunidad().getId());
		checkForeignKey.checkForeignKey(datos);
		return new ResponseBean(200, "Registro creado con id: " + genericService.save(facturaproveedor));
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/proveedores", method=RequestMethod.PUT)
	public<T> ResponseBean proveedorupdate(@RequestBody FacturaProveedorBean facturaproveedor) {
		HashMap<T, Integer> datos = new HashMap<T, Integer>();
		datos.put((T) facturaproveedor, facturaproveedor.getId());
		datos.put((T) facturaproveedor.getProveedor(),facturaproveedor.getProveedor().getId());
		datos.put((T) facturaproveedor.getTipofactura(), facturaproveedor.getTipofactura().getId());
		datos.put((T) facturaproveedor.getComunidad(), facturaproveedor.getComunidad().getId());
		checkForeignKey.checkForeignKey(datos);
		return new ResponseBean(200, genericService.saveOrUpdate(facturaproveedor));
	}
}
