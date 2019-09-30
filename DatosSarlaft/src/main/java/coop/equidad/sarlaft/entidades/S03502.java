package coop.equidad.sarlaft.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the S03502 database table.
 * 
 */
@Entity
@NamedQuery(name = "S03502.findAll", query = "SELECT s FROM S03502 s")
public class S03502 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private S03502PK id;

	@Temporal(TemporalType.DATE)
	private Date fecmod;

	@Temporal(TemporalType.DATE)
	private Date fecrea;

	private String sucmod;

	private String sucrea;

	private long texto;

	@Temporal(TemporalType.DATE)
	private Date valdate;

	private BigDecimal valnumber;

	private String valstring;

	public S03502() {
	}

	public Date getFecmod() {
		return this.fecmod;
	}

	public void setFecmod(Date fecmod) {
		this.fecmod = fecmod;
	}

	public Date getFecrea() {
		return this.fecrea;
	}

	public void setFecrea(Date fecrea) {
		this.fecrea = fecrea;
	}

	public String getSucmod() {
		return this.sucmod;
	}

	public void setSucmod(String sucmod) {
		this.sucmod = sucmod;
	}

	public String getSucrea() {
		return this.sucrea;
	}

	public void setSucrea(String sucrea) {
		this.sucrea = sucrea;
	}

	public long getTexto() {
		return texto;
	}

	public void setTexto(long texto) {
		this.texto = texto;
	}

	public Date getValdate() {
		return this.valdate;
	}

	public void setValdate(Date valdate) {
		this.valdate = valdate;
	}

	public BigDecimal getValnumber() {
		return this.valnumber;
	}

	public void setValnumber(BigDecimal valnumber) {
		this.valnumber = valnumber;
	}

	public String getValstring() {
		return this.valstring;
	}

	public void setValstring(String valstring) {
		this.valstring = valstring;
	}

	public S03502PK getId() {
		return id;
	}

	public void setId(S03502PK id) {
		this.id = id;
	}

}