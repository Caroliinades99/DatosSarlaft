package coop.equidad.sarlaft.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the S03SARLAFT database table.
 * 
 */
@Embeddable
public class S03sarlaftPK implements Serializable {
	private static final long serialVersionUID = 1L;

	public S03sarlaftPK() {

	}

	private String codigo;
	@Temporal(TemporalType.DATE)
	private Date fecvincula;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFecvincula() {
		return fecvincula;
	}

	public void setFecvincula(Date fecvincula) {
		this.fecvincula = fecvincula;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((fecvincula == null) ? 0 : fecvincula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		S03sarlaftPK other = (S03sarlaftPK) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (fecvincula == null) {
			if (other.fecvincula != null)
				return false;
		} else if (!fecvincula.equals(other.fecvincula))
			return false;
		return true;
	}

}
