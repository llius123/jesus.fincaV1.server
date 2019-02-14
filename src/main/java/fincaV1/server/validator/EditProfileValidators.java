package fincaV1.server.validator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fincaV1.server.entity.VecinoBean;

@Service
public class EditProfileValidators {

	@Autowired
	HttpServletRequest session;
	
	public VecinoBean validatorChangeProfile(VecinoBean vecino) {
		VecinoBean vecinoSession = (VecinoBean) session.getSession().getAttribute("vecino");
		VecinoBean vecinoUpdated = new VecinoBean();
		
		vecinoUpdated = vecino;
		vecinoUpdated.setComunidad(vecinoSession.getComunidad());
		vecinoUpdated.setId(vecinoSession.getId());
		vecinoUpdated.setPoblacion(vecinoSession.getPoblacion());
		vecinoUpdated.setPorcentaje_participacion(vecinoSession.getPorcentaje_participacion());
		vecinoUpdated.setId_tipovecino(vecinoSession.getId_tipovecino());
		
		if(vecino.getPass() != null) {
			vecinoUpdated.setPass(vecino.getPass());
		}else {
			vecinoUpdated.setPass(vecinoSession.getPass());
		}
		
		return  vecinoUpdated;
	}
}
