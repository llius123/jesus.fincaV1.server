package fincaV1.server.factory;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fincaV1.server.entity.VecinoBean;
import fincaV1.server.exception.NotLogginSesionException;
import fincaV1.server.helper.Helper;

@Service
public class SecureFactory {

	@Autowired
	private HttpServletRequest request;
	@Autowired
	Helper helper;

	public <T> T checkPermission() {
			//VecinoBean vecinoBean = (VecinoBean) request.getSession().getAttribute("vecino");
			helper.consoleLog(request.getSession().toString(), "checkpermision");
		return null;

	}

}
