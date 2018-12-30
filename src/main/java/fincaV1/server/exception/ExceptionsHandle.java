package fincaV1.server.exception;

import org.aspectj.weaver.ast.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import fincaV1.server.entity.ResponseBean;


@ControllerAdvice
public class ExceptionsHandle {
	
	public ResponseBean responseBean;
	
    @ExceptionHandler
	public ResponseEntity<ResponseBean> numberFormatException(NumberFormatException exc) {
    	ResponseBean oBean = new ResponseBean(400, "Error");
    	return new ResponseEntity<ResponseBean>(oBean, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler
    public ResponseEntity<ResponseBean> notLogginSesionException(NotLogginSesionException exc){
    	responseBean.setMsg(exc.getMessage());
    	responseBean.setStatus(401);
    	return new ResponseEntity<ResponseBean>(responseBean, HttpStatus.UNAUTHORIZED);
    }
    
}
