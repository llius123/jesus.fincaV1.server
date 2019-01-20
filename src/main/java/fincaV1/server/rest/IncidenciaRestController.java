package fincaV1.server.rest;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fincaV1.server.entity.IncidenciaBean;
import fincaV1.server.entity.ResponseBean;
import fincaV1.server.service.IncidenciaServiceImp;
import fincaV1.server.servicegeneric.GenericServiceImp;
import fincaV1.server.validator.CheckForeignKey;
import fincaV1.server.validator.SpecificValidators;


@RestController
public class IncidenciaRestController {
	
	@Autowired
	private GenericServiceImp genericService;
	@Autowired
	IncidenciaServiceImp incidenciaServiceImp;
	@Autowired 
	private CheckForeignKey checkForeignKey;
	@Autowired
	SpecificValidators specificValidator;
	
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
		HashMap<T, Integer> datos = new HashMap<T, Integer>();
		datos.put((T) incidencia.getVecino(),incidencia.getVecino().getId());
		checkForeignKey.checkForeignKey(datos);
		specificValidator.isDateValid(incidencia.getFecha_creacion().toString());
		return new ResponseBean(200, "Registro creado con id: " + genericService.save(incidencia));
	}
	
	@RequestMapping(value="/incidencias", method=RequestMethod.PUT)
	public<T> ResponseBean incidenciaupdate(@RequestBody IncidenciaBean incidencia) {
		HashMap<T, Integer> datos = new HashMap<T, Integer>();
		datos.put((T) incidencia,incidencia.getId());
		datos.put((T) incidencia.getVecino(),incidencia.getVecino().getId());
		checkForeignKey.checkForeignKey(datos);
		specificValidator.isDateValid(incidencia.getFecha_creacion().toString());
		return new ResponseBean(200, genericService.saveOrUpdate(incidencia));
	}
	
	@RequestMapping(value="/incidenciascount", method=RequestMethod.GET)
	public ResponseBean incidenciascount() {
		String numberString = String.valueOf(incidenciaServiceImp.incidenciascount().get(0));
		return new ResponseBean(200, numberString);
	}
	
	
}


















