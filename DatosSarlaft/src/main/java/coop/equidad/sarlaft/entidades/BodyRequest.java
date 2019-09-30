package coop.equidad.sarlaft.entidades;
/**
 * Esta es la entidad para el body del servicio Falabella
 * */
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BodyRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("num_propuesta")
	private Long numPropuesta;

	public Long getNumPropuesta() {
		return numPropuesta;
	}

	public void setNumPropuesta(Long numPropuesta) {
		this.numPropuesta = numPropuesta;
	}

}
