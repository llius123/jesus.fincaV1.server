package fincaV1.server.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fincaV1.server.entity.ComunidadBean;
import fincaV1.server.entity.ResponseBean;
import fincaV1.server.servicegeneric.GenericServiceImp;

@RestController
public class ComunidadRestController {

	@Autowired
	private GenericServiceImp genericService;
	
	@RequestMapping(value="/comunidades", method=RequestMethod.GET)
	public List<ComunidadBean> getAll() {
		return (List<ComunidadBean>) genericService.getAll(ComunidadBean.class);
	}
	
	@RequestMapping(value="/comunidades/{id}", method=RequestMethod.GET)
	public ComunidadBean get(@PathVariable int id) {
		return (ComunidadBean) genericService.get(ComunidadBean.class, id);
	}
	
	@RequestMapping(value="/comunidades/{id}", method=RequestMethod.DELETE)
	public ResponseBean delete(@PathVariable int id) {
		return new ResponseBean(200, genericService.delete(genericService.get(ComunidadBean.class, id)));
	}
	
	@RequestMapping(value="/comunidades", method=RequestMethod.POST)
	public ResponseBean save(@RequestBody ComunidadBean comunidad) {
		return new ResponseBean(200, "Registro creado con id: " + genericService.save(comunidad));
	}
	
	@RequestMapping(value="/comunidades", method=RequestMethod.PUT)
	public ResponseBean update(@RequestBody ComunidadBean comunidad) {
		return new ResponseBean(200, genericService.saveOrUpdate(comunidad));
	}
}
