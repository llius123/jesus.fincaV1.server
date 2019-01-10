package fincaV1.server.interceptor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fincaV1.server.entity.ComunidadBean;
import fincaV1.server.entity.IncidenciaBean;
import fincaV1.server.entity.VecinoBean;
import fincaV1.server.exception.NotExistForeignKey;
import fincaV1.server.exception.NotLogginSesionException;
import fincaV1.server.factory.CheckForeignKey;

@Component
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

		// Factoria de control para el body de PUT/POST
		// System.err.println(request.getServletPath());
		if(request.getMethod().contentEquals("POST") || request.getMethod().contentEquals("PUT")) {
			String body = request.getReader().lines().collect(Collectors.joining());
			factoryBody(request, body);
		}
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

	private <T> boolean factoryBody(HttpServletRequest request, String body) {
		HashMap<T, Integer> hashMap = new HashMap<T, Integer>();
		String path = request.getServletPath();
		String table = "";
		String auxS = "/";
		int count = 0;
		for (int i = 0; i < path.length(); i++) {
			boolean auxB = true;

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
		if (table.equals("incidencias")) {
			IncidenciaBean o = stringTopojo(body, IncidenciaBean.class);
			System.err.println(o.getVecino().getId());
		}
		return true;
	}
	
	private <T> T stringTopojo(String body, Class<T> type) {
		ObjectMapper objectMapper = new ObjectMapper();
		Object o = null;
		try {
			o = objectMapper.readValue(body,type);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (T) o;
	}

//	private Object o;
//
//	@RequestMapping
//	public void getBody(@RequestBody Object o) {
//		System.err.println(o.toString());
//		this.o = o;
//	}
}
