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
import org.springframework.web.bind.annotation.RestController;

import fincaV1.server.entity.IncidenciaBean;
import fincaV1.server.service.IncidenciaService;
import fincaV1.server.service.IncidenciaServiceImp;


@RestController
public class IncidenciaRestController {
	
	@Autowired
	private IncidenciaService oIncidenciaService;

	
	@RequestMapping(value="/testapi", method=RequestMethod.GET )
	public List<IncidenciaBean> testApi() {
		return oIncidenciaService.testApi();
	}
	
	
}


















