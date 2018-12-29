package fincaV1.server.rest;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fincaV1.server.entity.IncidenciaBean;
import fincaV1.server.entity.ResponseBean;
import fincaV1.server.helper.Helper;
import fincaV1.server.service.IncidenciaService;
import fincaV1.server.service.IncidenciaServiceImp;
import fincaV1.server.servicegeneric.GenericService;
import fincaV1.server.servicegeneric.GenericServiceImp;


@RestController
public class IncidenciaRestController {
	
	@Autowired
	private Helper helper;
	@Autowired
	private GenericServiceImp genericService;
	
	@RequestMapping(value="/incidencias", method=RequestMethod.GET)
	public List<IncidenciaBean> incidencias() {
		return (List<IncidenciaBean>) genericService.getAll(IncidenciaBean.class);
	}
	
	@RequestMapping(value="/incidencias/{id}", method=RequestMethod.GET)
	public IncidenciaBean incidencia(@PathVariable int id) {
		return (IncidenciaBean) genericService.get(IncidenciaBean.class, id);
	}
	
	@RequestMapping(value="/incidencias/{id}", method=RequestMethod.DELETE)
	public ResponseBean incidenciadelete(@PathVariable int id) {
		return new ResponseBean(200, genericService.delete(genericService.get(IncidenciaBean.class, id)));
	}
	
	@RequestMapping(value="/incidencias", method=RequestMethod.POST)
	public ResponseBean incidenciasave(@RequestBody IncidenciaBean incidencia) {
		return new ResponseBean(200, "Registro creado con id: " + genericService.save(incidencia));
	}
	
	@RequestMapping(value="/incidencias", method=RequestMethod.PUT)
	public ResponseBean incidenciaupdate(@RequestBody IncidenciaBean incidencia) {
		return new ResponseBean(200, genericService.saveOrUpdate(incidencia));
	}
	
	
}


















