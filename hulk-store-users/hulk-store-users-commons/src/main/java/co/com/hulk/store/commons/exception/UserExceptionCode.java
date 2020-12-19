package co.com.hulk.store.commons.exception;

public enum UserExceptionCode {
	
	EMAIL_REPEAT_EXCEPTION("El correo ya existe","001"),
	USER_NO_EXITS("El usuario no existe","002");
	
	private String mensaje;
	private String codigo;
	
	private UserExceptionCode(String mensaje, String codigo) {
		this.mensaje = mensaje;
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	


}
