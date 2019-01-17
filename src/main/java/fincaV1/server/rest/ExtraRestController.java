package fincaV1.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fincaV1.server.entity.TareaBean;
import fincaV1.server.servicegeneric.GenericServiceImp;

@RestController
public class ExtraRestController {

	@Autowired
	GenericServiceImp genericService;
	
	@RequestMapping(value="/count/{tabla}", method=RequestMethod.GET)
	public int count(@PathVariable String tabla) {
		return genericService.count(tabla);
	}
}
