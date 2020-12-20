package co.com.hulk.store.products.commons.exception.unit.of.measurement;

public enum UnitOfMeasurementCodeException {

	UNIT_OF_MEASUREMENT_ALREADY_EXISTS("La unidad de medida ya existe"),
	UNIT_OF_MEASUREMENT_NO_EXISTS("La unidad de medida no existe");

	private String mensaje;

	private UnitOfMeasurementCodeException(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

}
