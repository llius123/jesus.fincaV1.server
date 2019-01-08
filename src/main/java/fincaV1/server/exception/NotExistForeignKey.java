package fincaV1.server.exception;

public class NotExistForeignKey extends RuntimeException{
	
	public NotExistForeignKey(String message) {
		super(message);
	}

}
