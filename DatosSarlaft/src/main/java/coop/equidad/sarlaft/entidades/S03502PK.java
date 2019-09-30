package coop.equidad.sarlaft.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the S03502 database table.
 * 
 */
@Embeddable
public class S03502PK implements Serializable {
	private static final long serialVersionUID = 1L;

	public S03502PK() {
	}

	private String coddet;

	private String codigo;

	public String getCoddet() {
		return coddet;
	}

	public void setCoddet(String coddet) {
		this.coddet = coddet;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}