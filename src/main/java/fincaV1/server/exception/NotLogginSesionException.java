package fincaV1.server.exception;

public class NotLogginSesionException extends RuntimeException{
	
	public NotLogginSesionException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotLogginSesionException(String message) {
		super(message);
	}

	public NotLogginSesionException(Throwable cause) {
		super(cause);
	}

}
