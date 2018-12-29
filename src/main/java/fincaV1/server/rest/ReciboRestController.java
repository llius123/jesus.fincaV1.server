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
	public List<ReciboBean> recibos() {
		return (List<ReciboBean>) genericService.getAll(ReciboBean.class);
	}
	
	@RequestMapping(value="/recibos/{id}", method=RequestMethod.GET)
	public ReciboBean recibo(@PathVariable int id) {
		return (ReciboBean) genericService.get(ReciboBean.class, id);
	}
	
	@RequestMapping(value="/recibos/{id}", method=RequestMethod.DELETE)
	public ResponseBean recibodelete(@PathVariable int id) {
		return new ResponseBean(200, genericService.delete(genericService.get(ReciboBean.class, id)));
	}
	
	@RequestMapping(value="/recibos", method=RequestMethod.POST)
	public ResponseBean recibosave(@RequestBody ReciboBean recibo) {
		return new ResponseBean(200, "Registro creado con id: " + genericService.save(recibo));
	}
	
	@RequestMapping(value="/recibos", method=RequestMethod.PUT)
	public ResponseBean reciboupdate(@RequestBody ReciboBean recibo) {
		return new ResponseBean(200, genericService.saveOrUpdate(recibo));
	}

}
