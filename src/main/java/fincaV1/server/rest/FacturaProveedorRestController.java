package fincaV1.server.rest;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fincaV1.server.entity.FacturaProveedorBean;
import fincaV1.server.entity.ResponseBean;
import fincaV1.server.servicegeneric.GenericServiceImp;
import fincaV1.server.validator.CheckForeignKey;
import fincaV1.server.validator.SpecificValidators;

@RestController
public class FacturaProveedorRestController {

	@Autowired
	private GenericServiceImp genericService;
	@Autowired
	private CheckForeignKey checkForeignKey;
	@Autowired
	private SpecificValidators specificValidator;
	
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
	public<T> ResponseBean facturasave(@RequestBody FacturaProveedorBean factura) {
		HashMap<T, Integer> datos = new HashMap<T, Integer>();
		datos.put((T) factura.getProveedor(),factura.getProveedor().getId());
		datos.put((T) factura.getTipofactura(), factura.getTipofactura().getId());
		datos.put((T) factura.getComunidad(), factura.getComunidad().getId());
		checkForeignKey.checkForeignKey(datos);
		specificValidator.isDateValid(factura.getFecha_registro().toString());
		return new ResponseBean(200, "Registro creado con id: " + genericService.save(factura));
	}
	
	@RequestMapping(value="/facturaproveedores", method=RequestMethod.PUT)
	public<T> ResponseBean facturaupdate(@RequestBody FacturaProveedorBean factura) {
		HashMap<T, Integer> datos = new HashMap<T, Integer>();
		datos.put((T) factura,factura.getId());
		datos.put((T) factura.getProveedor(),factura.getProveedor().getId());
		datos.put((T) factura.getTipofactura(), factura.getTipofactura().getId());
		datos.put((T) factura.getComunidad(), factura.getComunidad().getId());
		checkForeignKey.checkForeignKey(datos);
		specificValidator.isDateValid(factura.getFecha_registro().toString());
		return new ResponseBean(200, genericService.saveOrUpdate(factura));
	}
}
