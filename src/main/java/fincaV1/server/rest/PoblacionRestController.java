package fincaV1.server.rest;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.io.DataOutputAsStream;

import fincaV1.server.entity.PoblacionBean;
import fincaV1.server.entity.ProvinciaBean;
import fincaV1.server.entity.ResponseBean;
import fincaV1.server.factory.CheckForeignKey;
import fincaV1.server.servicegeneric.GenericServiceImp;

@RestController
public class PoblacionRestController {

	@Autowired
	private GenericServiceImp genericService;
	@Autowired
	private CheckForeignKey checkForeignKey;
	
	@RequestMapping(value="/poblaciones", method=RequestMethod.GET)
	public List<PoblacionBean> poblacions() {
		return (List<PoblacionBean>) genericService.getAll(PoblacionBean.class);
	}
	
	@RequestMapping(value="/poblaciones/{id}", method=RequestMethod.GET)
	public PoblacionBean poblacion(@PathVariable int id) {
		return (PoblacionBean) genericService.get(PoblacionBean.class, id);
	}
	
	@RequestMapping(value="/poblaciones/{id}", method=RequestMethod.DELETE)
	public ResponseBean poblaciondelete(@PathVariable int id) {
		return new ResponseBean(200, genericService.delete(genericService.get(PoblacionBean.class, id)));
	}
	
	@RequestMapping(value="/poblaciones", method=RequestMethod.POST)
	public <T> ResponseBean poblacionsave(@RequestBody PoblacionBean poblacion) {
		HashMap<T, Integer> datos = new HashMap<T, Integer>();
		datos.put((T) poblacion.getCod_provincia(), poblacion.getCod_provincia().getCod_provincia());
		checkForeignKey.checkForeignKey(datos);
		return new ResponseBean(200, "Registro creado con id: " + genericService.save(poblacion));
	}
	
	@RequestMapping(value="/poblaciones", method=RequestMethod.PUT)
	public <T> ResponseBean poblacionupdate(@RequestBody PoblacionBean poblacion) {
		HashMap<T, Integer> datos = new HashMap<T, Integer>();
		datos.put((T) poblacion, poblacion.getCod_postal());
		datos.put((T) poblacion.getCod_provincia(), poblacion.getCod_provincia().getCod_provincia());
		checkForeignKey.checkForeignKey(datos);		
		return new ResponseBean(200, genericService.saveOrUpdate(poblacion));
	}
}
