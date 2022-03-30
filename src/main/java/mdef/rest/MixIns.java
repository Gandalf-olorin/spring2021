package mdef.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class MixIns {

	// Esto no se pedia en el enunciado
	@JsonPropertyOrder({ "nombreOTAN", "alcanceEnMetros", "calibre", "individual" })
	public static interface Fusil {

		@JsonProperty("nombreOTAN")
		abstract String getDenominacionOTAN();

	}

	// Esto no se pedia en el enunciado
	@JsonPropertyOrder({ "nombreUnidad", "operativo", "militaresDestinados" })
	public static interface Unidad {

		@JsonProperty("nombreUnidad")
		abstract String getNombre();

	}

	@JsonIgnoreProperties(value = { "bajaMedica" })
	@JsonPropertyOrder({ "empleo", "nombre", "fechaIngresoFas" })
	public static interface Militar {

	}

	public static interface Comision {

		@JsonProperty("inicioActivacion")
		abstract String getFechaActivacion();

		@JsonProperty("finActivacion")
		abstract String getFechaDesactivacion();

	}

}
