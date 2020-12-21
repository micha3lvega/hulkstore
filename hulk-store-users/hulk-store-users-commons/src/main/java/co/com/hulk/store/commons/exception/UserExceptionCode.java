package co.com.hulk.store.commons.exception;

public enum UserExceptionCode {

	EMAIL_REPEAT_EXCEPTION("El correo ya existe"), USER_NO_EXITS("El usuario no existe"),
	LOGIN_ERROR("Usuario o contraseña incorrectos"), INVALID_EMAIL("El correo es innecesario");

	private String mensaje;

	private UserExceptionCode(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

}
