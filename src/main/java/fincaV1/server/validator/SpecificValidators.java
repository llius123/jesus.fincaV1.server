package fincaV1.server.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;

import fincaV1.server.exception.BadBeanFormat;

@Service
public class SpecificValidators {

	final static String DATE_FORMAT = "yyyy-MM-dd";

	public void isDateValid(String date) {
		try {
			DateFormat df = new SimpleDateFormat(DATE_FORMAT);
			df.setLenient(false);
			df.parse(date);
		} catch (ParseException e) {
			throw new BadBeanFormat("Formato de fecha incorrecto!");
		}
	}
}
