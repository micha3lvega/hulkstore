package co.com.hulk.store.products.commons.exception.product;

public enum ProductCodeException {

	PRODUCT_ALREADY_EXISTS("El producto ya existe"), PRODUCT_NO_EXISTS("El producto no existe");

	private String mensaje;

	private ProductCodeException(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

}
