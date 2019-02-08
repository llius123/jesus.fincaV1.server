package fincaV1.server.validator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fincaV1.server.entity.VecinoBean;
import fincaV1.server.exception.NotLogginSesionException;
import fincaV1.server.exception.NotPermissionException;

@Service
public class CheckPermission {
	
	@Autowired
	HttpServletRequest servletRequest;
	
	public void checkPermissions(int permission) {
		VecinoBean vecinoSession = (VecinoBean) servletRequest.getSession().getAttribute("vecino");
		
		if(vecinoSession == null) throw new NotLogginSesionException("No estas logeado");
		
		if(vecinoSession.getId_tipovecino().getId() != permission) throw new NotPermissionException("No tienes permisos");
	}
	
	

}
