package fincaV1.server.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fincaV1.server.entity.ResponseBean;
import fincaV1.server.entity.TipovecinoBean;
import fincaV1.server.entity.VecinoBean;
import fincaV1.server.helper.Helper;
import fincaV1.server.servicegeneric.GenericService;
import fincaV1.server.servicegeneric.GenericServiceImp;

@RestController
public class TestRest {
//	@Autowired
//	private GenericService genericService;
	@Autowired
	private Helper helper;
	
	private ResponseBean responseBean;
	
//	@RequestMapping(value="/testgetall", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
//	public List<VecinoBean> test() {
//		List<VecinoBean> vecinos= (List<VecinoBean>) genericService.getAll(VecinoBean.class);
//		return vecinos;
//	}
//	
//	@RequestMapping(value="/testget/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
//	public VecinoBean test(@PathVariable long id) {
//		List<VecinoBean> vecinos=  (List<VecinoBean>) genericService.get(VecinoBean.class , id);
//		return vecinos.get(0);
//	}
//	/*
//	 * Con el save or update no hace falta el metodo save, porque si no le paso id el metodo crea un nuevo registro
//	 */
//	
//	@RequestMapping(value="/testsaveorupdate", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE )
//	public ResponseBean saveorupdate(@RequestBody TipovecinoBean o) {
//		return new ResponseBean(200, genericService.saveOrUpdate(o));
//	}
//	
//	@RequestMapping(value="/testdelete/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseBean testdelete(@PathVariable long id) {
//		TipovecinoBean o = genericService.get(TipovecinoBean.class, id);
//		return new ResponseBean(200,genericService.delete(o));
//	}

}