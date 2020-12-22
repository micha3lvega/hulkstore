package co.com.hulk.store.customer.commons.exception;

public enum CustomerExceptionCode {

	USER_CREATE_EXCEPTION("Error al momento de crear el usuario"),
	CUSTOMER_NO_EXITS("Cliente no encontrado");

	private String mensaje;

	private CustomerExceptionCode(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

}
