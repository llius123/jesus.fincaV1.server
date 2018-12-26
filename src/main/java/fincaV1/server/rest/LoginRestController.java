package fincaV1.server.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fincaV1.server.helper.Helper;

@RestController
public class LoginRestController {
	@Autowired
	Helper helper;
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET )
	public String login(HttpServletRequest request, HttpSession session) {
		session.invalidate();
		HttpSession newSesion = request.getSession();
		return "Sesion creada";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET )
	public String logou(HttpSession session) {
		session.invalidate();
		return "Sesion cerrada";
	}

}
