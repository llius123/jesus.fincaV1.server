package fincaV1.server.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fincaV1.server.entity.TareaBean;
import fincaV1.server.entity.ResponseBean;
import fincaV1.server.entity.TagBean;
import fincaV1.server.entity.TareaBean;
import fincaV1.server.entity.TipofacturaBean;
import fincaV1.server.servicegeneric.GenericServiceImp;
import fincaV1.server.validator.CheckForeignKey;
import fincaV1.server.validator.SpecificValidators;
import net.bytebuddy.utility.RandomString;

@RestController
public class TareaRestController {
	
	@Autowired
	GenericServiceImp genericService;
	@Autowired
	CheckForeignKey checkForeignKey;
	@Autowired
	SpecificValidators specificValidator;
	
	@RequestMapping(value="/tareas", method=RequestMethod.GET)
	@Transactional
	public List<TareaBean> tareas() {
		return (List<TareaBean>) genericService.getAll(TareaBean.class);
	}
	
	@RequestMapping(value="/tareas/{id}", method=RequestMethod.GET)
	@Transactional
	public TareaBean tareas(@PathVariable int id) {
		return genericService.get(TareaBean.class, id);
	}
	
	@RequestMapping(value="/tareas/{id}", method=RequestMethod.DELETE)
	@Transactional
	public ResponseBean tareasdelete(@PathVariable int id) {
		return new ResponseBean(200, genericService.delete(genericService.get(TareaBean.class, id)));
	}
	
	@RequestMapping(value="/tareas", method=RequestMethod.POST)
	@Transactional
	public<T> ResponseBean tareassave(@RequestBody TareaBean tarea) {
		System.err.println(tarea);
		return new ResponseBean(200, "Registro creado con id: " + genericService.save(tarea));
	}
	
	@RequestMapping(value="/tareas", method=RequestMethod.PUT)
	@Transactional
	public<T> ResponseBean tareasupdate(@RequestBody TareaBean tarea) {
		HashMap<T, Integer> datos = new HashMap<T, Integer>();
		datos.put((T) tarea, tarea.getId());
		checkForeignKey.checkForeignKey(datos);
		specificValidator.isDateValid(tarea.getFecha().toString());
		return new ResponseBean(200, genericService.saveOrUpdate(tarea));
	}

}
