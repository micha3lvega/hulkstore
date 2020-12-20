package co.com.hulk.store.products.commons.exception.brand;

public class BrandException extends Exception {

	private static final long serialVersionUID = 5719166073016329878L;

	public BrandException(BrandCodeException exceptionCode) {
		super(exceptionCode.getMensaje());
	}

	public BrandException(String mensaje) {
		super(mensaje);
	}

}
