package fincaV1.server.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fincaV1.server.entity.VecinoBean;
import fincaV1.server.exception.NotLogginSesionException;

@Component
public class FactoryInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		//Forma de saber si el ususario se quiere logear
		String login = request.getRequestURI().substring(16, 21);
		if(login.equals("login")) return true;
		
		//Compruebo si esta el usurio logeado
		if (request.getSession().getAttribute("vecino") == null)
			throw new NotLogginSesionException("No estas loegado");

		return true;
	}
}
