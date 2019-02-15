package fincaV1.server.rest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fincaV1.server.entity.FacturaProveedorBean;
import fincaV1.server.entity.ResponseBean;
import fincaV1.server.service.FacturaProveedorServiceImp;
import fincaV1.server.service.GraficoService;
import fincaV1.server.servicegeneric.GenericServiceImp;
import fincaV1.server.validator.CheckForeignKey;
import fincaV1.server.validator.CheckPermission;
import fincaV1.server.validator.SpecificValidators;

@RestController
public class FacturaProveedorRestController {

	@Autowired
	private GenericServiceImp genericService;
	@Autowired
	private CheckForeignKey checkForeignKey;
	@Autowired
	private SpecificValidators specificValidator;
	@Autowired
	FacturaProveedorServiceImp facturaProveedorServiceImp;
	@Autowired
	GraficoService graficoService;
	@Autowired
	CheckPermission check;

	@RequestMapping(value = "/facturaproveedores", method = RequestMethod.GET)
	public List<FacturaProveedorBean> facturas() {
		check.checkPermissions(1);
		return (List<FacturaProveedorBean>) genericService.getAll(FacturaProveedorBean.class);
	}
	
	@RequestMapping(value = "/facturaproveedoresusuario", method = RequestMethod.GET)
	public List<FacturaProveedorBean> facturas2() {
		check.checkPermissions(2);
		return (List<FacturaProveedorBean>) genericService.getAll(FacturaProveedorBean.class);
	}

	@RequestMapping(value = "/facturaproveedores/{id}", method = RequestMethod.GET)
	public FacturaProveedorBean factura(@PathVariable int id) {
		check.checkPermissions(1);
		return (FacturaProveedorBean) genericService.get(FacturaProveedorBean.class, id);
	}

	@RequestMapping(value = "/facturaproveedores/{id}", method = RequestMethod.DELETE)
	public ResponseBean facturadelete(@PathVariable int id) {
		check.checkPermissions(1);
		return new ResponseBean(200, genericService.delete(genericService.get(FacturaProveedorBean.class, id)));
	}

	@RequestMapping(value = "/facturaproveedores", method = RequestMethod.POST)
	public <T> ResponseBean facturasave(@RequestBody FacturaProveedorBean factura) {
		check.checkPermissions(1);
		HashMap<T, Integer> datos = new HashMap<T, Integer>();
		datos.put((T) factura.getProveedor(), factura.getProveedor().getId());
		datos.put((T) factura.getTipofactura(), factura.getTipofactura().getId());
		datos.put((T) factura.getComunidad(), factura.getComunidad().getId());
		checkForeignKey.checkForeignKey(datos);
		specificValidator.isDateValid(factura.getFecha_registro().toString());
		return new ResponseBean(200, "Registro creado con id: " + genericService.save(factura));
	}

	@RequestMapping(value = "/facturaproveedores", method = RequestMethod.PUT)
	public <T> ResponseBean facturaupdate(@RequestBody FacturaProveedorBean factura) {
		check.checkPermissions(1);
		HashMap<T, Integer> datos = new HashMap<T, Integer>();
		System.err.println(factura);
		datos.put((T) factura, factura.getId());
		datos.put((T) factura.getProveedor(), factura.getProveedor().getId());
		datos.put((T) factura.getTipofactura(), factura.getTipofactura().getId());
		datos.put((T) factura.getComunidad(), factura.getComunidad().getId());
		checkForeignKey.checkForeignKey(datos);
		specificValidator.isDateValid(factura.getFecha_registro().toString());
		return new ResponseBean(200, genericService.saveOrUpdate(factura));
	}

	@RequestMapping(value = "/facturaproveedores/filtrofecha/{desde}/{hasta}", method = RequestMethod.GET)
	public List<FacturaProveedorBean> facturafiltrofecha(@PathVariable String desde, @PathVariable String hasta) {
		check.checkPermissions(1);
		specificValidator.isDateValid(desde);
		specificValidator.isDateValid(hasta);
		return facturaProveedorServiceImp.facturaFiltroFecha(desde, hasta);
	}
	@RequestMapping(value = "/facturaproveedoresusuario/filtrofecha/{desde}/{hasta}", method = RequestMethod.GET)
	public List<FacturaProveedorBean> facturafiltrofecha2(@PathVariable String desde, @PathVariable String hasta) {
		check.checkPermissions(1);
		specificValidator.isDateValid(desde);
		specificValidator.isDateValid(hasta);
		return facturaProveedorServiceImp.facturaFiltroFecha(desde, hasta);
	}

	@RequestMapping(value = "/facturaproveedores/filtrogeneral/{tabla}/{dato}", method = RequestMethod.GET)
	public List<FacturaProveedorBean> facturafiltrogeneral(@PathVariable String tabla, @PathVariable String dato) {
		check.checkPermissions(1);
		return facturaProveedorServiceImp.facturaFiltroGeneral(tabla, dato);
	}

	@RequestMapping(value = "/facturaproveedores/facturagraficocobrado", method = RequestMethod.GET)
	public ArrayList<ArrayList<String>> facturaGraficoCobrado() {
		check.checkPermissions(1);
		return graficoService.graficoCobrado();
	}
	
	@RequestMapping(value="/facturaproveedores/facturagraficotipofactura", method = RequestMethod.GET)
	public ArrayList<ArrayList<String>> facturaGraficoTipoFactura() {
		check.checkPermissions(1);
		return graficoService.graficoTipofactura();
	}
}
