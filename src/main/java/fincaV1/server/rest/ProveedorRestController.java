package fincaV1.server.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fincaV1.server.entity.ProveedorBean;
import fincaV1.server.entity.ResponseBean;
import fincaV1.server.servicegeneric.GenericServiceImp;

@RestController
public class ProveedorRestController {
	@Autowired
	private GenericServiceImp genericService;
	
	@RequestMapping(value="/proveedores", method=RequestMethod.GET)
	public List<ProveedorBean> incidencias() {
		return (List<ProveedorBean>) genericService.getAll(ProveedorBean.class);
	}
	
	@RequestMapping(value="/proveedores/{id}", method=RequestMethod.GET)
	public ProveedorBean incidencia(@PathVariable int id) {
		return (ProveedorBean) genericService.get(ProveedorBean.class, id);
	}
	
	@RequestMapping(value="/proveedores/{id}", method=RequestMethod.DELETE)
	public ResponseBean incidenciadelete(@PathVariable int id) {
		return new ResponseBean(200, genericService.delete(genericService.get(ProveedorBean.class, id)));
	}
	
	@RequestMapping(value="/proveedores", method=RequestMethod.POST)
	public ResponseBean incidenciasave(@RequestBody ProveedorBean incidencia) {
		return new ResponseBean(200, "Registro creado con id: " + genericService.save(incidencia));
	}
	
	@RequestMapping(value="/proveedores", method=RequestMethod.PUT)
	public ResponseBean incidenciaupdate(@RequestBody ProveedorBean incidencia) {
		return new ResponseBean(200, genericService.saveOrUpdate(incidencia));
	}
}
