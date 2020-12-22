package co.com.hulk.store.customer.commons.exception;

public class CustomerException extends Exception {

	private static final long serialVersionUID = 3788869081407046359L;

	public CustomerException(CustomerExceptionCode exceptionCode) {
		super(exceptionCode.getMensaje());
	}

	public CustomerException(String mensaje) {
		super(mensaje);
	}

}
