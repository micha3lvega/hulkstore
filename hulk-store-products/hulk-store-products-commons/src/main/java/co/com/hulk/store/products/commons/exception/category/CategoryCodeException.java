package co.com.hulk.store.products.commons.exception.category;

public enum CategoryCodeException {

	CATEGORY_ALREADY_EXISTS("La categoria ya existe"), CATEGORY_NO_EXISTS("La categoria no existe");

	private String mensaje;

	private CategoryCodeException(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

}
