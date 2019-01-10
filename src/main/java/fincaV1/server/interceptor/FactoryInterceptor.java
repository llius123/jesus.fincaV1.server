package fincaV1.server.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fincaV1.server.entity.ComunidadBean;
import fincaV1.server.entity.VecinoBean;
import fincaV1.server.exception.NotLogginSesionException;
import fincaV1.server.factory.CheckForeignKey;

@Component
public class FactoryInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	CheckForeignKey checkForeignKey;
	@Autowired
	HttpServletRequest request;
	

	public <T> boolean preHandle() throws Exception {

		throw new NotLogginSesionException("HOLA");
		
		// Forma de saber si el ususario se quiere logear
//		String login = request.getRequestURI().substring(16, 21);
//		if (login.equals("login"))
//			return true;
//
//		// Compruebo si esta el usurio logeado
//		if (request.getSession().getAttribute("vecino") == null)
//			throw new NotLogginSesionException("No estas loegado");

//		if (request.getMethod().equals("POST")) {
//			if (object.getClass().toString().equals("ComunidadBean")) {
//				throw new NotLogginSesionException("Funciona");
//			}
//		}
		//return true;
	}
}
