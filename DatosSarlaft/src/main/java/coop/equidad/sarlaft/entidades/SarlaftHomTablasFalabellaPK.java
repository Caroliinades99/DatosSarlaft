package coop.equidad.sarlaft.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SarlaftHomTablasFalabellaPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "CODIGO_FALABELLA")
	private String codigoFalabella;
	
	@Column(name = "TIPO_TABLA")
	private int tipo_Table;

	public String getCodigoFalabella() {
		return codigoFalabella;
	}

	public void setCodigoFalabella(String codigoFalabella) {
		this.codigoFalabella = codigoFalabella;
	}

	public int getTipo_Table() {
		return tipo_Table;
	}

	public void setTipo_Table(int tipo_Table) {
		this.tipo_Table = tipo_Table;
	}

}
