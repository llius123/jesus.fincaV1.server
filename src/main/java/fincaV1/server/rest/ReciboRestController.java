package fincaV1.server.rest;

import java.util.HashMap;
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
import fincaV1.server.validator.CheckForeignKey;
import fincaV1.server.validator.CheckPermission;
import fincaV1.server.validator.SpecificValidators;

@RestController
public class ReciboRestController {
	
	@Autowired
	private GenericServiceImp genericService;
	@Autowired
	private CheckForeignKey checkForeignKey;
	@Autowired
	SpecificValidators specificValidator;
	@Autowired
	CheckPermission check;
	
	@RequestMapping(value="/recibos", method=RequestMethod.GET)
	public List<ReciboBean> recibos() {
		check.checkPermissions(1);
		return (List<ReciboBean>) genericService.getAll(ReciboBean.class);
	}
	
	@RequestMapping(value="/recibos/{id}", method=RequestMethod.GET)
	public ReciboBean recibo(@PathVariable int id) {
		check.checkPermissions(1);
		return (ReciboBean) genericService.get(ReciboBean.class, id);
	}
	
	@RequestMapping(value="/recibos/{id}", method=RequestMethod.DELETE)
	public ResponseBean recibodelete(@PathVariable int id) {
		check.checkPermissions(1);
		return new ResponseBean(200, genericService.delete(genericService.get(ReciboBean.class, id)));
	}
	
	@RequestMapping(value="/recibos", method=RequestMethod.POST)
	public<T> ResponseBean recibosave(@RequestBody ReciboBean recibo) {
		check.checkPermissions(1);
		HashMap<T, Integer> datos = new HashMap<T, Integer>();
		datos.put((T) recibo.getVecino(), recibo.getVecino().getId());
		checkForeignKey.checkForeignKey(datos);
		specificValidator.isDateValid(recibo.getFecha_emision().toString());
		specificValidator.isDateValid(recibo.getFecha_cobro().toString());
		return new ResponseBean(200, "Registro creado con id: " + genericService.save(recibo));
	}
	
	@RequestMapping(value="/recibos", method=RequestMethod.PUT)
	public<T> ResponseBean reciboupdate(@RequestBody ReciboBean recibo) {
		check.checkPermissions(1);
		HashMap<T, Integer> datos = new HashMap<T, Integer>();
		datos.put((T) recibo, recibo.getId());
		datos.put((T) recibo.getVecino(), recibo.getVecino().getId());
		checkForeignKey.checkForeignKey(datos);
		specificValidator.isDateValid(recibo.getFecha_emision().toString());
		specificValidator.isDateValid(recibo.getFecha_cobro().toString());
		return new ResponseBean(200, genericService.saveOrUpdate(recibo));
	}

}
