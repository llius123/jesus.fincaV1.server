package fincaV1.server.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fincaV1.server.entity.FacturaProveedorBean;
import fincaV1.server.entity.ResponseBean;
import fincaV1.server.servicegeneric.GenericServiceImp;

@RestController
public class FacturaProveedorRestController {

	@Autowired
	private GenericServiceImp genericService;
	
	@RequestMapping(value="/facturaproveedores", method=RequestMethod.GET)
	public List<FacturaProveedorBean> facturas() {
		return (List<FacturaProveedorBean>) genericService.getAll(FacturaProveedorBean.class);
	}
	
	@RequestMapping(value="/facturaproveedores/{id}", method=RequestMethod.GET)
	public FacturaProveedorBean factura(@PathVariable int id) {
		return (FacturaProveedorBean) genericService.get(FacturaProveedorBean.class, id);
	}
	
	@RequestMapping(value="/facturaproveedores/{id}", method=RequestMethod.DELETE)
	public ResponseBean facturadelete(@PathVariable int id) {
		return new ResponseBean(200, genericService.delete(genericService.get(FacturaProveedorBean.class, id)));
	}
	
	@RequestMapping(value="/facturaproveedores", method=RequestMethod.POST)
	public ResponseBean facturasave(@RequestBody FacturaProveedorBean factura) {
		return new ResponseBean(200, "Registro creado con id: " + genericService.save(factura));
	}
	
	@RequestMapping(value="/facturaproveedores", method=RequestMethod.PUT)
	public ResponseBean facturaupdate(@RequestBody FacturaProveedorBean factura) {
		return new ResponseBean(200, genericService.saveOrUpdate(factura));
	}
}
