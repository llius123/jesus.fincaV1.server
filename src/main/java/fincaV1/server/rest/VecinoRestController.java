package fincaV1.server.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fincaV1.server.entity.VecinoBean;
import fincaV1.server.entity.ResponseBean;
import fincaV1.server.servicegeneric.GenericServiceImp;

@RestController
public class VecinoRestController {

	@Autowired
	private GenericServiceImp genericService;
	
	@RequestMapping(value="/vecinos", method=RequestMethod.GET)
	public List<VecinoBean> vecinos() {
		return (List<VecinoBean>) genericService.getAll(VecinoBean.class);
	}
	
	@RequestMapping(value="/vecinos/{id}", method=RequestMethod.GET)
	public VecinoBean vecino(@PathVariable int id) {
		return (VecinoBean) genericService.get(VecinoBean.class, id);
	}
	
	@RequestMapping(value="/vecinos/{id}", method=RequestMethod.DELETE)
	public ResponseBean vecinodelete(@PathVariable int id) {
		return new ResponseBean(200, genericService.delete(genericService.get(VecinoBean.class, id)));
	}
	
	@RequestMapping(value="/vecinos", method=RequestMethod.POST)
	public ResponseBean vecinosave(@RequestBody VecinoBean vecino) {
		return new ResponseBean(200, "Registro creado con id: " + genericService.save(vecino));
	}
	
	@RequestMapping(value="/vecinos", method=RequestMethod.PUT)
	public ResponseBean vecinoupdate(@RequestBody VecinoBean vecino) {
		return new ResponseBean(200, genericService.saveOrUpdate(vecino));
	}
}
