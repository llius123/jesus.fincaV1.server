package fincaV1.server.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fincaV1.server.daogeneric.GenericDaoImp;
import fincaV1.server.entity.ResponseBean;
import fincaV1.server.entity.VecinoBean;
import fincaV1.server.exception.NotLogginSesionException;
import fincaV1.server.helper.Helper;
import fincaV1.server.service.VecinoService;
import fincaV1.server.service.VecinoServiceImp;

@RestController
public class LoginRestController {
	@Autowired
	private Helper helper;
	@Autowired
	private VecinoService vecinoService;

	private ResponseBean responseBean;

	@RequestMapping(value = "/login/{user}/{pass}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean login(HttpServletResponse response, HttpServletRequest request, HttpSession session,
			@PathVariable String user, @PathVariable String pass) {
		//session.invalidate();
		List<VecinoBean> oVecinoBean = vecinoService.login(user, pass);

		if (!oVecinoBean.isEmpty()) {
			HttpSession newSesion = request.getSession();
			newSesion.setAttribute("vecino", oVecinoBean.get(0));
			//request.getSession().setAttribute("vecino", oVecinoBean);
			responseBean = new ResponseBean(200, "Login correcto");
		} else {
			responseBean = new ResponseBean(401, "Bad login");
		}
		response.setStatus(responseBean.getStatus());
		return responseBean;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ResponseBean logout(HttpSession session) {
		session.invalidate();
		return new ResponseBean(200, "logout correcto");
	}

	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public VecinoBean check(HttpServletRequest session) {
		if(session.getSession().getAttribute("vecino") == null) throw new NotLogginSesionException("No estas logeado");
		return (VecinoBean) session.getSession().getAttribute("vecino");
	}

}
