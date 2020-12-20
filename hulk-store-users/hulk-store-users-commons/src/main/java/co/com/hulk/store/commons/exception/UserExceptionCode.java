package co.com.hulk.store.commons.exception;

public enum UserExceptionCode {

	EMAIL_REPEAT_EXCEPTION("El correo ya existe", "001"), USER_NO_EXITS("El usuario no existe", "002"),
	LOGIN_ERROR("Usuario o contraseña incorrectos", "003"), INVALID_EMAIL("El correo es innecesario","004");

	private String mensaje;
	private String codigo;

	private UserExceptionCode(String mensaje, String codigo) {
		this.mensaje = mensaje;
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public String getCodigo() {
		return codigo;
	}

}
