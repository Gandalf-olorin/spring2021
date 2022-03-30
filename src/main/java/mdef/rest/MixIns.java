package mdef.rest;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class MixIns {

	@JsonPropertyOrder({ "empleo", "nombre", "fechaIngresoFas" })
	@JsonIgnoreProperties(value = { "bajaMedica" })
	public static interface Militares {
	}

	@JsonPropertyOrder({ "nombre", "individual", "alcance", "calibre" })
	public static interface Comisiones {
		@JsonProperty("inicioActivacion")
		abstract LocalDateTime getFechaActivacion();

		@JsonProperty("finActivacion")
		abstract LocalDateTime getFechaDesactivacion();

	}
}
