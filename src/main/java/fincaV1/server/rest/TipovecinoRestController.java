package fincaV1.server.rest;

import java.util.HashMap;
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
import fincaV1.server.validator.CheckForeignKey;
import fincaV1.server.validator.CheckPermission;

@RestController
public class TipovecinoRestController {

	@Autowired
	private GenericServiceImp genericService;
	@Autowired 
	private CheckForeignKey checkForeignKey;
	@Autowired
	CheckPermission check;
	
	
	@RequestMapping(value="/tipovecinos", method=RequestMethod.GET)
	public List<TipovecinoBean> tipovecinos() {
		check.checkPermissions(1);
		return (List<TipovecinoBean>) genericService.getAll(TipovecinoBean.class);
	}
	
	@RequestMapping(value="/tipovecinos/{id}", method=RequestMethod.GET)
	public TipovecinoBean tipovecino(@PathVariable int id) {
		check.checkPermissions(1);
		return (TipovecinoBean) genericService.get(TipovecinoBean.class, id);
	}
	
//	@RequestMapping(value="/tipovecinos/{id}", method=RequestMethod.DELETE)
//	public ResponseBean tipovecinodelete(@PathVariable int id) {
//		check.checkPermissions(1);
//		return new ResponseBean(200, genericService.delete(genericService.get(TipovecinoBean.class, id)));
//	}
//	
//	@RequestMapping(value="/tipovecinos", method=RequestMethod.POST)
//	public ResponseBean tipovecinosave(@RequestBody TipovecinoBean tipovecino) {
//		check.checkPermissions(1);
//		return new ResponseBean(200, "Registro creado con id: " + genericService.save(tipovecino));
//	}
//	
//	@RequestMapping(value="/tipovecinos", method=RequestMethod.PUT)
//	public<T> ResponseBean tipovecinoupdate(@RequestBody TipovecinoBean tipovecino) {
//		check.checkPermissions(1);
//		HashMap<T, Integer> datos = new HashMap<T, Integer>();
//		datos.put((T) tipovecino, tipovecino.getId());
//		checkForeignKey.checkForeignKey(datos);
//		return new ResponseBean(200, genericService.saveOrUpdate(tipovecino));
//	}
}
