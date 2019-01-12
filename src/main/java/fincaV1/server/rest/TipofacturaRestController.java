package fincaV1.server.rest;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fincaV1.server.entity.TipofacturaBean;
import fincaV1.server.entity.ResponseBean;
import fincaV1.server.servicegeneric.GenericServiceImp;
import fincaV1.server.validator.CheckForeignKey;

@RestController
public class TipofacturaRestController {

	@Autowired
	private GenericServiceImp genericService;
	@Autowired 
	private CheckForeignKey checkForeignKey;
	
	@RequestMapping(value="/tipofacturas", method=RequestMethod.GET)
	public List<TipofacturaBean> tipofacturas() {
		return (List<TipofacturaBean>) genericService.getAll(TipofacturaBean.class);
	}
	
	@RequestMapping(value="/tipofacturas/{id}", method=RequestMethod.GET)
	public TipofacturaBean tipofactura(@PathVariable int id) {
		return (TipofacturaBean) genericService.get(TipofacturaBean.class, id);
	}
	
	@RequestMapping(value="/tipofacturas/{id}", method=RequestMethod.DELETE)
	public ResponseBean tipofacturadelete(@PathVariable int id) {
		return new ResponseBean(200, genericService.delete(genericService.get(TipofacturaBean.class, id)));
	}
	
	@RequestMapping(value="/tipofacturas", method=RequestMethod.POST)
	public ResponseBean tipofacturasave(@RequestBody TipofacturaBean tipofactura) {
		return new ResponseBean(200, "Registro creado con id: " + genericService.save(tipofactura));
	}
	
	@RequestMapping(value="/tipofacturas", method=RequestMethod.PUT)
	public<T> ResponseBean tipofacturaupdate(@RequestBody TipofacturaBean tipofactura) {
		HashMap<T, Integer> datos = new HashMap<T, Integer>();
		datos.put((T) tipofactura, tipofactura.getId());
		checkForeignKey.checkForeignKey(datos);
		return new ResponseBean(200, genericService.saveOrUpdate(tipofactura));
	}
}
