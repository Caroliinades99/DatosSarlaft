package coop.equidad.sarlaft.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQuery(name = "S03105.findAll", query = "SELECT s FROM S03105 s")
public class S03105 implements Serializable {
	private static final long serialVersionUID = 1L;

	private String asgdet;
	private String asgval;

	private String coddet;

	@Id
	private String codigo;

	private String codpad;

	@Temporal(TemporalType.DATE)
	private Date fecini;

	@Temporal(TemporalType.DATE)
	private Date fecter;

	private String metodoex;

	private String nivel;

	private String nombre;

	public String getAsgdet() {
		return this.asgdet;
	}

	public void setAsgdet(String asgdet) {
		this.asgdet = asgdet;
	}

	public String getAsgval() {
		return this.asgval;
	}

	public void setAsgval(String asgval) {
		this.asgval = asgval;
	}

	public String getCoddet() {
		return this.coddet;
	}

	public void setCoddet(String coddet) {
		this.coddet = coddet;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodpad() {
		return this.codpad;
	}

	public void setCodpad(String codpad) {
		this.codpad = codpad;
	}

	public Date getFecini() {
		return this.fecini;
	}

	public void setFecini(Date fecini) {
		this.fecini = fecini;
	}

	public Date getFecter() {
		return this.fecter;
	}

	public void setFecter(Date fecter) {
		this.fecter = fecter;
	}

	public String getMetodoex() {
		return this.metodoex;
	}

	public void setMetodoex(String metodoex) {
		this.metodoex = metodoex;
	}

	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}