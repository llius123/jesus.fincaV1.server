package fincaV1.server.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fincaV1.server.entity.TipovecinoBean;
import fincaV1.server.entity.ResponseBean;
import fincaV1.server.servicegeneric.GenericServiceImp;

@RestController
public class TipovecinoRestController {

	@Autowired
	private GenericServiceImp genericService;
	
	@RequestMapping(value="/tipovecinos", method=RequestMethod.GET)
	public List<TipovecinoBean> tipovecinos() {
		return (List<TipovecinoBean>) genericService.getAll(TipovecinoBean.class);
	}
	
	@RequestMapping(value="/tipovecinos/{id}", method=RequestMethod.GET)
	public TipovecinoBean tipovecino(@PathVariable int id) {
		return (TipovecinoBean) genericService.get(TipovecinoBean.class, id);
	}
	
	@RequestMapping(value="/tipovecinos/{id}", method=RequestMethod.DELETE)
	public ResponseBean tipovecinodelete(@PathVariable int id) {
		return new ResponseBean(200, genericService.delete(genericService.get(TipovecinoBean.class, id)));
	}
	
	@RequestMapping(value="/tipovecinos", method=RequestMethod.POST)
	public ResponseBean tipovecinosave(@RequestBody TipovecinoBean tipovecino) {
		return new ResponseBean(200, "Registro creado con id: " + genericService.save(tipovecino));
	}
	
	@RequestMapping(value="/tipovecinos", method=RequestMethod.PUT)
	public ResponseBean tipovecinoupdate(@RequestBody TipovecinoBean tipovecino) {
		return new ResponseBean(200, genericService.saveOrUpdate(tipovecino));
	}
}
