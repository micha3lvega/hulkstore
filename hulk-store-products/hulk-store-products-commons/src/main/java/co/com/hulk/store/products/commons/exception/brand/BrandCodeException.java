package co.com.hulk.store.products.commons.exception.brand;

public enum BrandCodeException {

	BRAND_ALREADY_EXISTS("La marca ya existe"), BRAND_NO_EXISTS("La marca no existe");

	private String mensaje;

	private BrandCodeException(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

}
