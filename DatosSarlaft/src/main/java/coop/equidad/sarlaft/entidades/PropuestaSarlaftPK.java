package coop.equidad.sarlaft.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class PropuestaSarlaftPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codigo;
	private String propuesta;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecinicio;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getPropuesta() {
		return propuesta;
	}

	public void setPropuesta(String propuesta) {
		this.propuesta = propuesta;
	}

	public Date getFecinicio() {
		return fecinicio;
	}

	public void setFecinicio(Date fecinicio) {
		this.fecinicio = fecinicio;
	}

}
