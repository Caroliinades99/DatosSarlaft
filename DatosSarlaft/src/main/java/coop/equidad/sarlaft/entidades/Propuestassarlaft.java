package coop.equidad.sarlaft.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * The persistent class for the PROPUESTASSARLAFT database table.
 * 
 */
@Entity
@NamedQuery(name = "Propuestassarlaft.findAll", query = "SELECT p FROM Propuestassarlaft p")
public class Propuestassarlaft implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PropuestaSarlaftPK id;

	public PropuestaSarlaftPK getId() {
		return id;
	}

	public void setId(PropuestaSarlaftPK id) {
		this.id = id;
	}

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fecfin;

	private String mensaje1;
	private String mensaje;

	public Propuestassarlaft() {
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecfin() {
		return this.fecfin;
	}

	public void setFecfin(Date fecfin) {
		this.fecfin = fecfin;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje1() {
		return mensaje1;
	}

	public void setMensaje1(String mensaje1) {
		this.mensaje1 = mensaje1;
	}


}
