package fincaV1.server.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fincaV1.server.entity.ReciboBean;
import fincaV1.server.entity.ResponseBean;
import fincaV1.server.servicegeneric.GenericServiceImp;

@RestController
public class ReciboRestController {
	
	@Autowired
	private GenericServiceImp genericService;
	
	@RequestMapping(value="/recibos", method=RequestMethod.GET)
	public List<ReciboBean> incidencias() {
		return (List<ReciboBean>) genericService.getAll(ReciboBean.class);
	}
	
	@RequestMapping(value="/recibos/{id}", method=RequestMethod.GET)
	public ReciboBean incidencia(@PathVariable int id) {
		return (ReciboBean) genericService.get(ReciboBean.class, id);
	}
	
	@RequestMapping(value="/recibos/{id}", method=RequestMethod.DELETE)
	public ResponseBean incidenciadelete(@PathVariable int id) {
		return new ResponseBean(200, genericService.delete(genericService.get(ReciboBean.class, id)));
	}
	
	@RequestMapping(value="/recibos", method=RequestMethod.POST)
	public ResponseBean incidenciasave(@RequestBody ReciboBean incidencia) {
		return new ResponseBean(200, "Registro creado con id: " + genericService.save(incidencia));
	}
	
	@RequestMapping(value="/recibos", method=RequestMethod.PUT)
	public ResponseBean incidenciaupdate(@RequestBody ReciboBean incidencia) {
		return new ResponseBean(200, genericService.saveOrUpdate(incidencia));
	}

}
