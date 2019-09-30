package coop.equidad.sarlaft.entidades;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name = "S03sarlaftInversiones.findAll", query = "SELECT s FROM S03sarlaftInversiones s")
public class S03sarlaftInversiones {

	private static final long serialVersionUID = 1L;

	@Column(name = "CODIGO")
	private String codigoInver;

	@Column(name = "FECVINCULA")
	@Temporal(TemporalType.DATE)
	private Date fechaVinculacionInver;

	@Id
	@Column(name = "SECUENCIA")
	private int secuenciaInver;

	@Column(name = "TIPO")
	private String tipoProductoInver;

	@Column(name = "IDENTIFICACION")
	private String indentificacionInver;

	@Column(name = "ENTIDAD")
	private String entidadInver;

	@Column(name = "MONTO")
	private BigDecimal montoInver;

	@Column(name = "CIUDAD")
	private String ciudadInver;

	@Column(name = "PAIS")
	private String paisInver;

	@Column(name = "MONEDA")
	private int monedaInver;

	public String getCodigoInver() {
		return codigoInver;
	}

	public void setCodigoInver(String codigoInver) {
		this.codigoInver = codigoInver;
	}

	public Date getFechaVinculacionInver() {
		return fechaVinculacionInver;
	}

	public void setFechaVinculacionInver(Date fechaVinculacionInver) {
		this.fechaVinculacionInver = fechaVinculacionInver;
	}

	public int getSecuenciaInver() {
		return secuenciaInver;
	}

	public void setSecuenciaInver(int secuenciaInver) {
		this.secuenciaInver = secuenciaInver;
	}

	public String getTipoProductoInver() {
		return tipoProductoInver;
	}

	public void setTipoProductoInver(String tipoProductoInver) {
		this.tipoProductoInver = tipoProductoInver;
	}

	public String getIndentificacionInver() {
		return indentificacionInver;
	}

	public void setIndentificacionInver(String indentificacionInver) {
		this.indentificacionInver = indentificacionInver;
	}

	public String getEntidadInver() {
		return entidadInver;
	}

	public void setEntidadInver(String entidadInver) {
		this.entidadInver = entidadInver;
	}

	public BigDecimal getMontoInver() {
		return montoInver;
	}

	public void setMontoInver(BigDecimal montoInver) {
		this.montoInver = montoInver;
	}

	public String getCiudadInver() {
		return ciudadInver;
	}

	public void setCiudadInver(String ciudadInver) {
		this.ciudadInver = ciudadInver;
	}

	public String getPaisInver() {
		return paisInver;
	}

	public void setPaisInver(String paisInver) {
		this.paisInver = paisInver;
	}

	public int getMonedaInver() {
		return monedaInver;
	}

	public void setMonedaInver(int monedaInver) {
		this.monedaInver = monedaInver;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
