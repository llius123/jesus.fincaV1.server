package fincaV1.server.interceptor;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import fincaV1.server.exception.NotLogginSesionException;
import fincaV1.server.validator.CheckForeignKey;

@Repository
public class FactoryInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	CheckForeignKey checkForeignKey;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// Forma de saber si el ususario se quiere logear
		if (isLogin(request))
			return true;
		// Compruebo si hay sesion en server
		if (!isLogged(request))
			throw new NotLogginSesionException("No estas logeado");

		return true;
	}

	private boolean isLogin(HttpServletRequest request) {
		String login = request.getRequestURI().substring(16, 21);
		if (login.equals("login")) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isLogged(HttpServletRequest request) {
		if (request.getSession().getAttribute("vecino") == null) {
			return false;
		} else {
			return true;
		}
	}

}
