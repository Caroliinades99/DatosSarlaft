package coop.equidad.sarlaft.entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "SARLAFT_HOM_TABLAS_FALABELLA")
@NamedQuery(name = "SarlaftHomTablasFalabella.findAll", query = "SELECT s FROM SarlaftHomTablasFalabella s")
public class SarlaftHomTablasFalabella implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SarlaftHomTablasFalabellaPK id;

	@Column(name = "CODIGO_EQUIDAD")
	private String codigoEquidad;

	private String descripcion;

	public SarlaftHomTablasFalabellaPK getId() {
		return id;
	}

	public void setId(SarlaftHomTablasFalabellaPK id) {
		this.id = id;
	}

	public String getCodigoEquidad() {
		return this.codigoEquidad;
	}

	public void setCodigoEquidad(String codigoEquidad) {
		this.codigoEquidad = codigoEquidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}