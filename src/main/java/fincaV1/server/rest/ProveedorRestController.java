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
import fincaV1.server.servicegeneric.GenericServiceImp;
import fincaV1.server.validator.CheckForeignKey;
import fincaV1.server.validator.CheckPermission;

@RestController
public class ProveedorRestController {
	@Autowired
	private GenericServiceImp genericService;
	@Autowired
	private CheckForeignKey checkForeignKey;
	@Autowired
	CheckPermission check;
	
	@RequestMapping(value="/proveedores", method=RequestMethod.GET)
	public List<ProveedorBean> proveedors() {
		check.checkPermissions(1);
		return (List<ProveedorBean>) genericService.getAll(ProveedorBean.class);
	}
	
	@RequestMapping(value="/proveedores/{id}", method=RequestMethod.GET)
	public ProveedorBean proveedor(@PathVariable int id) {
		check.checkPermissions(1);
		return (ProveedorBean) genericService.get(ProveedorBean.class, id);
	}
	
	@RequestMapping(value="/proveedores/{id}", method=RequestMethod.DELETE)
	public ResponseBean proveedordelete(@PathVariable int id) {
		check.checkPermissions(1);
		return new ResponseBean(200, genericService.delete(genericService.get(ProveedorBean.class, id)));
	}
	
	@RequestMapping(value="/proveedores", method=RequestMethod.POST)
	public <T> ResponseBean proveedorsave(@RequestBody ProveedorBean proveedor) {
		check.checkPermissions(1);
		HashMap<T, Integer> datos = new HashMap<T, Integer>();
		datos.put((T) proveedor.getPoblacion(), proveedor.getPoblacion().getCod_postal());
		checkForeignKey.checkForeignKey(datos);
		return new ResponseBean(200, "Registro creado con id: " + genericService.save(proveedor));
	}
	
	@RequestMapping(value="/proveedores", method=RequestMethod.PUT)
	public<T> ResponseBean proveedorupdate(@RequestBody ProveedorBean proveedor) {
		check.checkPermissions(1);
		HashMap<T, Integer> datos = new HashMap<T, Integer>();
		datos.put((T) proveedor, proveedor.getId());
		datos.put((T) proveedor.getPoblacion(), proveedor.getPoblacion().getCod_postal());
		checkForeignKey.checkForeignKey(datos);
		return new ResponseBean(200, genericService.saveOrUpdate(proveedor));
	}
}
