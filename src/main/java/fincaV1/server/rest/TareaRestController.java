package fincaV1.server.rest;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fincaV1.server.entity.TareaBean;
import fincaV1.server.entity.ResponseBean;
import fincaV1.server.entity.TareaBean;
import fincaV1.server.entity.TipofacturaBean;
import fincaV1.server.servicegeneric.GenericServiceImp;
import fincaV1.server.validator.CheckForeignKey;
import fincaV1.server.validator.SpecificValidators;

@RestController
public class TareaRestController {
	
	@Autowired
	GenericServiceImp genericService;
	@Autowired
	CheckForeignKey checkForeignKey;
	@Autowired
	SpecificValidators specificValidator;
	
	@RequestMapping(value="/tareas", method=RequestMethod.GET)
	public List<TareaBean> tipofacturas() {
		return (List<TareaBean>) genericService.getAll(TareaBean.class);
	}
	
	@RequestMapping(value="/tareas/{id}", method=RequestMethod.GET)
	public TareaBean recibo(@PathVariable int id) {
		return (TareaBean) genericService.get(TareaBean.class, id);
	}
	
	@RequestMapping(value="/tareas/{id}", method=RequestMethod.DELETE)
	public ResponseBean recibodelete(@PathVariable int id) {
		return new ResponseBean(200, genericService.delete(genericService.get(TareaBean.class, id)));
	}
	
	@RequestMapping(value="/tareas", method=RequestMethod.POST)
	public<T> ResponseBean tareasave(@RequestBody TareaBean tarea) {
		return new ResponseBean(200, "Registro creado con id: " + genericService.save(tarea));
	}
	
	@RequestMapping(value="/tareas", method=RequestMethod.PUT)
	public<T> ResponseBean reciboupdate(@RequestBody TareaBean tarea) {
		HashMap<T, Integer> datos = new HashMap<T, Integer>();
		datos.put((T) tarea, tarea.getId());
		checkForeignKey.checkForeignKey(datos);
		specificValidator.isDateValid(tarea.getFecha().toString());
		return new ResponseBean(200, genericService.saveOrUpdate(tarea));
	}

}
