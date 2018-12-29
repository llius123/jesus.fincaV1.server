package fincaV1.server.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fincaV1.server.entity.PoblacionBean;
import fincaV1.server.entity.ResponseBean;
import fincaV1.server.servicegeneric.GenericServiceImp;

@RestController
public class PoblacionRestController {

	@Autowired
	private GenericServiceImp genericService;
	
	@RequestMapping(value="/poblaciones", method=RequestMethod.GET)
	public List<PoblacionBean> incidencias() {
		return (List<PoblacionBean>) genericService.getAll(PoblacionBean.class);
	}
	
	@RequestMapping(value="/poblaciones/{id}", method=RequestMethod.GET)
	public PoblacionBean incidencia(@PathVariable int id) {
		return (PoblacionBean) genericService.get(PoblacionBean.class, id);
	}
	
	@RequestMapping(value="/poblaciones/{id}", method=RequestMethod.DELETE)
	public ResponseBean incidenciadelete(@PathVariable int id) {
		return new ResponseBean(200, genericService.delete(genericService.get(PoblacionBean.class, id)));
	}
	
	@RequestMapping(value="/poblaciones", method=RequestMethod.POST)
	public ResponseBean incidenciasave(@RequestBody PoblacionBean incidencia) {
		return new ResponseBean(200, "Registro creado con id: " + genericService.save(incidencia));
	}
	
	@RequestMapping(value="/poblaciones", method=RequestMethod.PUT)
	public ResponseBean incidenciaupdate(@RequestBody PoblacionBean incidencia) {
		return new ResponseBean(200, genericService.saveOrUpdate(incidencia));
	}
}
