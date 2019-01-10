package fincaV1.server.rest;

import java.util.HashMap;
import java.util.List;

import javax.validation.ValidationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fincaV1.server.entity.IncidenciaBean;
import fincaV1.server.entity.ResponseBean;
import fincaV1.server.factory.CheckForeignKey;
import fincaV1.server.factory.SecureFactory;
import fincaV1.server.helper.Helper;
import fincaV1.server.servicegeneric.GenericServiceImp;


@RestController
public class IncidenciaRestController {
	
	@Autowired
	private Helper helper;
	@Autowired
	private GenericServiceImp genericService;
	@Autowired
	private SecureFactory secureFactory;
	@Autowired
	private Validator validator;
	@Autowired 
	private CheckForeignKey checkForeignKey;
	
	@RequestMapping(value="/incidencias", method=RequestMethod.GET)
	public List<IncidenciaBean> incidencias() {
		return (List<IncidenciaBean>) genericService.getAll(IncidenciaBean.class);
	}
	
	@RequestMapping(value="/incidencias/{id}", method=RequestMethod.GET)
	public IncidenciaBean incidencia(@PathVariable int id){
		return (IncidenciaBean) genericService.get(IncidenciaBean.class, id);			
	}
	
	@RequestMapping(value="/incidencias/{id}", method=RequestMethod.DELETE)
	public ResponseBean incidenciadelete(@PathVariable int id) {
		return new ResponseBean(200, genericService.delete(genericService.get(IncidenciaBean.class, id)));
	}
	
	@RequestMapping(value="/incidencias", method=RequestMethod.POST)
	public<T> ResponseBean incidenciasave(@RequestBody IncidenciaBean incidencia){
		return new ResponseBean(200, "Registro creado con id: " + genericService.save(incidencia));
	}
	
	@RequestMapping(value="/incidencias", method=RequestMethod.PUT)
	public<T> ResponseBean incidenciaupdate(@RequestBody IncidenciaBean incidencia) {
		HashMap<T, Integer> datos = new HashMap<T, Integer>();
		datos.put((T) incidencia,incidencia.getId());
		datos.put((T) incidencia.getVecino(),incidencia.getVecino().getId());
		checkForeignKey.checkForeignKey(datos);
		return new ResponseBean(200, genericService.saveOrUpdate(incidencia));
	}
	
	
}


















