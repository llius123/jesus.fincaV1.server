package fincaV1.server.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerInterceptor;

import fincaV1.server.entity.VecinoBean;
import fincaV1.server.exception.NotPermissionException;
import javassist.bytecode.annotation.NoSuchClassError;

@Repository
public class PermissionInterceptor {
	
	public void permissionCheck(HttpServletRequest request) {
		String tablaString ="";
		tablaString = getTable(request);
		VecinoBean vecinoSessionBean = (VecinoBean) request.getSession().getAttribute("vecino");
		
		if(vecinoSessionBean.getId_tipovecino().getId() == 1) {
			
		}else if(vecinoSessionBean.getId_tipovecino().getId() == 2) {
			throw new NotPermissionException("No tienes permiso!");
		}
		
	}
	
	//Destrozo la url caracter a caracter para obtener la tabla a la que hace referencia
	private String getTable(HttpServletRequest request) {
		String path = request.getServletPath();
		String table = "";
		String auxS = "/";
		int count = 0;
		//Obtengo la tabla a la que estoy haciendo el request
		//http...../incidencias/...
		//Estoy recojiendo incidencias en este bucle
		for (int i = 0; i < path.length(); i++) {

			if (auxS.equals(String.valueOf(path.charAt(i)))) {
				if (count == 0) {
					count++;
				} else {
					i = path.length();
				}
			} else {
				table = table + path.charAt(i);
			}
		}
		return table;
	}
}
