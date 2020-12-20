package co.com.hulk.store.products.commons.exception.category;

public class CategoryException extends Exception {

	private static final long serialVersionUID = -7965356011589851937L;

	public CategoryException(CategoryCodeException exceptionCode) {
		super(exceptionCode.getMensaje());
	}

	public CategoryException(String mensaje) {
		super(mensaje);
	}
	
}
