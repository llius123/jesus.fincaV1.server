package fincaV1.server.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fincaV1.server.entity.ResponseBean;
import fincaV1.server.entity.VecinoBean;
import fincaV1.server.service.TestService;

@RestController
public class TestRest {
	@Autowired
	private TestService testService;
	
	@RequestMapping(value="/testgetall", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<VecinoBean> test() {
		List<VecinoBean> vecinos= (List<VecinoBean>) testService.getAll(VecinoBean.class);
		return vecinos;
	}
	
	@RequestMapping(value="/testget/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public VecinoBean test(@PathVariable int id) {
		List<VecinoBean> vecinos= (List<VecinoBean>) testService.getAll(VecinoBean.class);
		return vecinos.get(0);
	}

}
