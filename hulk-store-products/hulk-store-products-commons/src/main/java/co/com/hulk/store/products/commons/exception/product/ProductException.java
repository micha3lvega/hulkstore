package co.com.hulk.store.products.commons.exception.product;

public class ProductException extends Exception {

	private static final long serialVersionUID = 6403329457157341371L;

	public ProductException(ProductCodeException exceptionCode) {
		super(exceptionCode.getMensaje());
	}

	public ProductException(String mensaje) {
		super(mensaje);
	}

}
