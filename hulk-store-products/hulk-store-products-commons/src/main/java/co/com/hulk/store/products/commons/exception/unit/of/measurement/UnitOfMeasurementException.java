package co.com.hulk.store.products.commons.exception.unit.of.measurement;

public class UnitOfMeasurementException extends Exception {

	private static final long serialVersionUID = -1581802347118199610L;

	public UnitOfMeasurementException(UnitOfMeasurementCodeException exceptionCode) {
		super(exceptionCode.getMensaje());
	}

	public UnitOfMeasurementException(String mensaje) {
		super(mensaje);
	}

}
