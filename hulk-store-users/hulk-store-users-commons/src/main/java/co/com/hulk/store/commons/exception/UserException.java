package co.com.hulk.store.commons.exception;

public class UserException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserException(UserExceptionCode exceptionCode) {
		super(exceptionCode.getMensaje());
	}

	public UserException(String mensaje) {
		super(mensaje);
	}

}
