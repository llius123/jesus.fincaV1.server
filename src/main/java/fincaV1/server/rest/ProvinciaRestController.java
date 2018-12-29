package fincaV1.server.rest;

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

@RestController
public class ProvinciaRestController {

	@Autowired
	private GenericServiceImp genericService;
	
	@RequestMapping(value="/provincias", method=RequestMethod.GET)
	public List<ProvinciaBean> incidencias() {
		return (List<ProvinciaBean>) genericService.getAll(ProvinciaBean.class);
	}
	
	@RequestMapping(value="/provincias/{id}", method=RequestMethod.GET)
	public ProvinciaBean incidencia(@PathVariable int id) {
		return (ProvinciaBean) genericService.get(ProvinciaBean.class, id);
	}
	
	@RequestMapping(value="/provincias/{id}", method=RequestMethod.DELETE)
	public ResponseBean incidenciadelete(@PathVariable int id) {
		return new ResponseBean(200, genericService.delete(genericService.get(ProvinciaBean.class, id)));
	}
	
	@RequestMapping(value="/provincias", method=RequestMethod.POST)
	public ResponseBean incidenciasave(@RequestBody ProvinciaBean incidencia) {
		return new ResponseBean(200, "Registro creado con id: " + genericService.save(incidencia));
	}
	
	@RequestMapping(value="/provincias", method=RequestMethod.PUT)
	public ResponseBean incidenciaupdate(@RequestBody ProvinciaBean incidencia) {
		return new ResponseBean(200, genericService.saveOrUpdate(incidencia));
	}
}
