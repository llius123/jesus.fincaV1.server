package fincaV1.server.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import fincaV1.server.entity.ResponseBean;


@ControllerAdvice
public class ExceptionsHandle {
//	@Autowired
//	private HttpServletResponse response;
	
    @ExceptionHandler
	public ResponseEntity<ResponseBean> handleException(NumberFormatException exc) {
    	ResponseBean oBean = new ResponseBean(400, "Error");
    	return new ResponseEntity<ResponseBean>(oBean, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
