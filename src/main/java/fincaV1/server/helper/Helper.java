package fincaV1.server.helper;

import java.util.logging.Logger;

import org.springframework.stereotype.Component;

@Component
public class Helper {

	private Logger logger = Logger.getLogger(getClass().getName());
	
	public void consoleLog(String msg, String lugar) {
		logger.info("Lugar: " + lugar);
		logger.info("Mensaje: " + msg);
	}
}
