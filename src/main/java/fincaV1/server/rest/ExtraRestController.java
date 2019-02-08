package fincaV1.server.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fincaV1.server.entity.TareaBean;
import fincaV1.server.servicegeneric.GenericServiceImp;
import fincaV1.server.validator.CheckPermission;

@RestController
public class ExtraRestController {

	@Autowired
	GenericServiceImp genericService;
	@Autowired
	CheckPermission check;
	
	@RequestMapping(value="/count/{tabla}", method=RequestMethod.GET)
	public int count(@PathVariable String tabla) {
		check.checkPermissions(1);
		return genericService.count(tabla);
	}
}
