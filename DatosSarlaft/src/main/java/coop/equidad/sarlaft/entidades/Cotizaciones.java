package coop.equidad.sarlaft.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vw_propuestas")
public class Cotizaciones implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "valstring")
	private String valstring;

	public String getValstring() {
		return valstring;
	}

	public void setValstring(String valstring) {
		this.valstring = valstring;
	}
}
