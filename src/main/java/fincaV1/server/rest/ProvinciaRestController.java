package fincaV1.server.rest;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fincaV1.server.entity.ProvinciaBean;
import fincaV1.server.entity.ResponseBean;
import fincaV1.server.servicegeneric.GenericServiceImp;
import fincaV1.server.validator.CheckForeignKey;
import fincaV1.server.validator.CheckPermission;

@RestController
public class ProvinciaRestController {

	@Autowired
	private GenericServiceImp genericService;
	@Autowired
	private CheckForeignKey checkForeignKey;
	@Autowired
	CheckPermission check;
	
	@RequestMapping(value="/provincias", method=RequestMethod.GET)
	public List<ProvinciaBean> provincias() {
		check.checkPermissions(1);
		return (List<ProvinciaBean>) genericService.getAll(ProvinciaBean.class);
	}
	
	@RequestMapping(value="/provincias/{id}", method=RequestMethod.GET)
	public ProvinciaBean provincia(@PathVariable int id) {
		check.checkPermissions(1);
		return (ProvinciaBean) genericService.get(ProvinciaBean.class, id);
	}
	
	@RequestMapping(value="/provincias/{id}", method=RequestMethod.DELETE)
	public ResponseBean provinciadelete(@PathVariable int id) {
		check.checkPermissions(1);
		return new ResponseBean(200, genericService.delete(genericService.get(ProvinciaBean.class, id)));
	}
	
	@RequestMapping(value="/provincias", method=RequestMethod.POST)
	public ResponseBean provinciasave(@RequestBody ProvinciaBean provincia) {
		check.checkPermissions(1);
		return new ResponseBean(200, "Registro creado con id: " + genericService.save(provincia));
	}
	
	@RequestMapping(value="/provincias", method=RequestMethod.PUT)
	public<T> ResponseBean provinciaupdate(@RequestBody ProvinciaBean provincia) {
		check.checkPermissions(1);
		HashMap<T, Integer> datos = new HashMap<T, Integer>();
		datos.put((T) provincia, provincia.getId());
		checkForeignKey.checkForeignKey(datos);
		return new ResponseBean(200, genericService.saveOrUpdate(provincia));
	}
}
