package fincaV1.server.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fincaV1.server.entity.ComunidadBean;
import fincaV1.server.entity.VecinoBean;
import fincaV1.server.exception.NotExistForeignKey;
import fincaV1.server.exception.NotLogginSesionException;
import fincaV1.server.factory.CheckForeignKey;

@Component
public class FactoryInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	CheckForeignKey checkForeignKey;
	@Autowired
	HttpServletRequest request;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		//Forma de saber si el ususario se quiere logear
		if (isLogin())
			return true;
		//Compruebo si hay sesion en server
		if(!isLogged())
			throw new NotLogginSesionException("No estas logeado");

		return true;
	}

	private boolean isLogin() {
		String login = request.getRequestURI().substring(16, 21);
		if (login.equals("login")) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isLogged() {
		if (request.getSession().getAttribute("vecino") == null) {
			return false;
		}else {
			return true;
		}
	}
}
