package fincaV1.server.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fincaV1.server.entity.IncidenciaBean;
import fincaV1.server.entity.VecinoBean;
import fincaV1.server.exception.BadBeanFormat;
import fincaV1.server.exception.NotExistForeignKey;
import fincaV1.server.servicegeneric.GenericServiceImp;

@Service
public class IncidenciaBeanValidator {

	@Autowired
	private GenericServiceImp genericServiceImp;

	public void postValidator(IncidenciaBean incidencia) {
		if(genericServiceImp.get(VecinoBean.class, incidencia.getVecino().getId()) == null) throw new NotExistForeignKey("No existe el vecino con esa id");
		if(incidencia.getDescripcion().isEmpty()) error("Descripcion");
		if(!isDateValid(incidencia.getFecha_creacion().toString())) error("Fecha_creacion");
		if(!incidencia.getAtendido().equals("s") && !incidencia.getAtendido().equals("n")) error("Atendido");
	}

	public void putValidator() {

	}

	final static String DATE_FORMAT = "yyyy-MM-dd";

	public static boolean isDateValid(String date) {
		try {
			DateFormat df = new SimpleDateFormat(DATE_FORMAT);
			df.setLenient(false);
			df.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	public void error(String nombre) {
		throw new BadBeanFormat("El formato del objeto: " + nombre + " en el Bean de Incidencia no es correcto");
	}
}
