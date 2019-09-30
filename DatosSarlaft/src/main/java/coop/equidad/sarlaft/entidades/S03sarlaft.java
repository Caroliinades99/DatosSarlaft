package coop.equidad.sarlaft.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the S03SARLAFT database table.
 * 
 */
@Entity
@NamedQuery(name = "S03sarlaft.findAll", query = "SELECT s FROM S03sarlaft s")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "basicos_falabella", procedureName = "osiris.pr_datos_basicos_falabella", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_produ", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "Linea", type = String.class) }) })

public class S03sarlaft implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private S03sarlaftPK id;

	public S03sarlaftPK getId() {
		return id;
	}

	public void setId(S03sarlaftPK id) {
		this.id = id;
	}

	@Column(name = "ACT_ECONOMICA")
	private String actEconomica;

	@Column(name = "ACT_ECONOMICA_OTRA")
	private String actEconomicaOtra;

	@Column(name = "ACT_ECONOMICA_PJ")
	private BigDecimal actEconomicaPj;

	@Column(name = "ACT_ECONOMICA_RL")
	private String actEconomicaRl;

	@Column(name = "ACT_ESPECIFICACION")
	private String actEspecificacion;

	@Column(name = "ACT_PODER_PUBLICO")
	private BigDecimal actPoderPublico;

	@Column(name = "ACT_PUBLICO_GENERAL")
	private BigDecimal actPublicoGeneral;

	@Column(name = "ACT_RECURSOS_PUBLICOS")
	private BigDecimal actRecursosPublicos;

	@Column(name = "ACTECONOMICA_ASEGURADO")
	private String acteconomicaAsegurado;

	private BigDecimal activos;

	@Column(name = "ACTIVOS_AS")
	private BigDecimal activosAs;

	@Column(name = "ACTIVOS_PJ")
	private BigDecimal activosPj;

	private BigDecimal alertas;

	private BigDecimal calidad;

	@Column(name = "CANT_REPROCESOS")
	private BigDecimal cantReprocesos;

	private String cargo;

	@Column(name = "CARGOS_OFICIALES")
	private BigDecimal cargosOficiales;

	private String cedulaentrevista;

	@Column(name = "CEL_RESIDENCIA")
	private String celResidencia;

	@Column(name = "CIU_ASEGURADO")
	private String ciuAsegurado;

	@Column(name = "CIU_RESIDENCIA")
	private String ciuResidencia;

	private String ciudad;

	@Column(name = "CIUDAD_PJ")
	private String ciudadPj;

	@Column(name = "CIUDAD_SUCURSAL")
	private String ciudadSucursal;

	private int clasevinculacion;

	private String clasevinculacioncual;

	@Column(name = "COD_CAUSAL_DEVOLUCION")
	private String codCausalDevolucion;

	@Column(name = "COMERCIAL_EQUIDAD")
	private BigDecimal comercialEquidad;

	@Column(name = "CONCEPTO_OTROSINGRESOS")
	private String conceptoOtrosingresos;

	@Column(name = "CONCEPTOOTROSINGRESOS_AS")
	private String conceptootrosingresosAs;

	@Column(name = "CONCEPTOOTROSINGRESOS_PJ")
	private String conceptootrosingresosPj;

	private BigDecimal cuentasmonedaextranjera;

	@Column(name = "D_PRIMAS_SOCIEDAD")
	private BigDecimal dPrimasSociedad;

	@Column(name = "D_SOCIEDAD_COMERCIO")
	private BigDecimal dSociedadComercio;

	private BigDecimal declararenta;

	private String descripcioncalidad;

	@Column(name = "DESCRIPCIONTOMADOR_ASEGURADO")
	private String descripciontomadorAsegurado;

	@Column(name = "DIR_ASEGURADO")
	private String dirAsegurado;

	@Column(name = "DIR_RESIDENCIA")
	private String dirResidencia;

	private String direccion;

	@Column(name = "DIRECCION_PJ")
	private String direccionPj;

	@Column(name = "DIRECCION_SUCURSAL")
	private String direccionSucursal;

	@Column(name = "DOC_FCC")
	private String docFcc;

	@Column(name = "DOC1_FCC")
	private String doc1Fcc;

	private BigDecimal egresos;

	@Column(name = "EGRESOS_AS")
	private BigDecimal egresosAs;

	@Column(name = "EGRESOS_PJ")
	private BigDecimal egresosPj;

	private String email;

	@Column(name = "EMAIL_RL")
	private String emailRl;

	@Column(name = "ESTADO_LLAMADA")
	private BigDecimal estadoLlamada;

	@Column(name = "ESTADO_SOLI")
	private BigDecimal estadoSoli;

	private BigDecimal estadocivil;

	@Column(name = "ESTRATO_FCC")
	private BigDecimal estratoFcc;

	private String fax;

	@Column(name = "FAX_PJ")
	private String faxPj;

	@Column(name = "FAX_SUCURSAL")
	private String faxSucursal;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_EXPEDICION")
	private Date fechaExpedicion;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_NACIMIENTO")
	private Date fechaNacimiento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaentrevista;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHAEXPEDICION_ASEGURADO")
	private Date fechaexpedicionAsegurado;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHANACIMIENTO_ASEGURADO")
	private Date fechanacimientoAsegurado;

	@Column(name = "ID_ASEGURADO")
	private String idAsegurado;

	@Column(name = "ID_SOLICITUD")
	private BigDecimal idSolicitud;

	private String idconfirmadatos;

	@Column(name = "IDENTIFICACION_RL")
	private String identificacionRl;

	private BigDecimal ingresos;

	@Column(name = "INGRESOS_AS")
	private BigDecimal ingresosAs;

	@Column(name = "INGRESOS_PJ")
	private BigDecimal ingresosPj;

	@Column(name = "INSTITUCION_FINANCIERA")
	private BigDecimal institucionFinanciera;

	@Column(name = "JURIDICA_RAZONSOCIAL")
	private String juridicaRazonsocial;

	@Column(name = "LUGAR_EXPEDICION")
	private String lugarExpedicion;

	private String lugarentrevista;

	@Column(name = "LUGAREXPEDICION_ASEGURADO")
	private String lugarexpedicionAsegurado;

	@Column(name = "LUGARYFECHAEXP_RL")
	private String lugaryfechaexpRl;

	private BigDecimal monedaextranjera;

	private String nacionalidad;

	@Column(name = "NACIONALIDAD_RL")
	private String nacionalidadRl;

	private String nacionalidad2;

	@Column(name = "NACIONALIDAD2_RL")
	private String nacionalidad2Rl;

	private String nit;

	@Column(name = "NOMBRE_CARGO")
	private String nombreCargo;

	@Column(name = "NOMBRE_COMERCIAL")
	private String nombreComercial;

	@Column(name = "NOMBRE_CONFIRMADATOS")
	private String nombreConfirmadatos;

	@Column(name = "NOMBRE_EMPRESA")
	private String nombreEmpresa;

	@Column(name = "NOMBRE_INSTITUCION")
	private String nombreInstitucion;

	@Column(name = "NOMBRE_SEGUROS")
	private String nombreSeguros;

	private String nombreentrevista;

	@Column(name = "NUMERO_IDENTIFICACION")
	private String numeroIdentificacion;

	private BigDecimal numerohijos;

	@Column(name = "OBJETO_SOCIAL")
	private String objetoSocial;

	@Column(name = "OBLIGACIONES_OTROPAIS")
	private BigDecimal obligacionesOtropais;

	@Column(name = "OBLIGACIONES_OTROPAIS_DESC")
	private String obligacionesOtropaisDesc;

	private String observacionconfirmadatos;

	private String observaciones;

	private String ocupacion;

	@Column(name = "OTRO_MONEDAEXTRANJERA")
	private String otroMonedaextranjera;

	@Column(name = "OTROS_INGRESOS")
	private BigDecimal otrosIngresos;

	@Column(name = "OTROSINGRESOS_AS")
	private BigDecimal otrosingresosAs;

	@Column(name = "OTROSINGRESOS_PJ")
	private BigDecimal otrosingresosPj;

	@Column(name = "PAGINA_WEB_PJ")
	private String paginaWebPj;

	private BigDecimal pasivos;

	@Column(name = "PASIVOS_AS")
	private BigDecimal pasivosAs;

	@Column(name = "PASIVOS_PJ")
	private BigDecimal pasivosPj;

	private int pep;

	@Column(name = "PRIMER_APELLIDO")
	private String primerApellido;

	@Column(name = "PRIMER_NOMBRE")
	private String primerNombre;

	@Column(name = "PRIMER_NOMBRE_RL")
	private String primerNombreRl;

	@Column(name = "PRIMERAPELLIDO_ASEGURADO")
	private String primerapellidoAsegurado;

	@Column(name = "PRIMERAPELLIDO_RL")
	private String primerapellidoRl;

	@Column(name = "PRIMERNOMBRE_ASEGURADO")
	private String primernombreAsegurado;

	private BigDecimal productosexterior;

	@Column(name = "PROVIENEN_RECURSOS")
	private String provienenRecursos;

	@Column(name = "R_PRIMAS_SOCIEDAD")
	private BigDecimal rPrimasSociedad;

	@Column(name = "R_SOCIEDAD_COMERCIO")
	private BigDecimal rSociedadComercio;

	@Column(name = "REF_COMERCIAL")
	private BigDecimal refComercial;

	private int resultado;

	@Column(name = "SEGUNDO_APELLIDO")
	private String segundoApellido;

	@Column(name = "SEGUNDO_NOMBRE")
	private String segundoNombre;

	@Column(name = "SEGUNDOAPELLIDO_ASEGURADO")
	private String segundoapellidoAsegurado;

	@Column(name = "SEGUNDOAPELLIDO_RL")
	private String segundoapellidoRl;

	@Column(name = "SEGUNDONOMBRE_ASEGURADO")
	private String segundonombreAsegurado;

	@Column(name = "SEGUNDONOMBRE_RL")
	private String segundonombreRl;

	@Column(name = "SEGUROS_CAPITALIZACION")
	private BigDecimal segurosCapitalizacion;

	private int sexo;

	private String siniestro;

	private String sucmod;

	private String sucrea;

	private String sucur;

	@Column(name = "TEL_RESIDENCIA")
	private String telResidencia;

	private String telefono;

	@Column(name = "TELEFONO_ASEGURADO")
	private String telefonoAsegurado;

	@Column(name = "TELEFONO_PJ")
	private String telefonoPj;

	@Column(name = "TELEFONO_SUCURSAL")
	private String telefonoSucursal;

	@Column(name = "TIPO_EMPRESA")
	private BigDecimal tipoEmpresa;

	@Column(name = "TIPO_FCC")
	private BigDecimal tipoFcc;

	@Column(name = "TIPO_MONEDAEXTRANJERA")
	private BigDecimal tipoMonedaextranjera;

	@Column(name = "TIPO_PRODUCTO")
	private String tipoProducto;

	@Column(name = "TIPO_SOCIEDAD")
	private BigDecimal tipoSociedad;

	@Column(name = "TIPO_SOCIEDAD_OTRA")
	private String tipoSociedadOtra;

	private int tipoactividad;

	@Column(name = "TIPODOCUMENTO_RL")
	private BigDecimal tipodocumentoRl;

	private BigDecimal tipoidentificacion;

	@Column(name = "TIPOIDENTIFICACION_ASEGURADO")
	private BigDecimal tipoidentificacionAsegurado;

	private BigDecimal tipopersona;

	@Column(name = "TIPOPOLIZA_FCC")
	private BigDecimal tipopolizaFcc;

	private BigDecimal tiporegimen;

	private BigDecimal tipovinculacion1;

	private BigDecimal tipovinculacion2;

	private BigDecimal tipovinculacion3;

	private BigDecimal tipovinculacion4;

	@Column(name = "VIN_PEP")
	private BigDecimal vinPep;

	@Column(name = "VIN_PEP_DESCRIPCION")
	private String vinPepDescripcion;

	private BigDecimal vinculos;

	public S03sarlaft() {
	}

	public String getActEconomica() {
		return this.actEconomica;
	}

	public void setActEconomica(String actEconomica) {
		this.actEconomica = actEconomica;
	}

	public String getActEconomicaOtra() {
		return this.actEconomicaOtra;
	}

	public void setActEconomicaOtra(String actEconomicaOtra) {
		this.actEconomicaOtra = actEconomicaOtra;
	}

	public BigDecimal getActEconomicaPj() {
		return this.actEconomicaPj;
	}

	public void setActEconomicaPj(BigDecimal actEconomicaPj) {
		this.actEconomicaPj = actEconomicaPj;
	}

	public String getActEconomicaRl() {
		return this.actEconomicaRl;
	}

	public void setActEconomicaRl(String actEconomicaRl) {
		this.actEconomicaRl = actEconomicaRl;
	}

	public String getActEspecificacion() {
		return this.actEspecificacion;
	}

	public void setActEspecificacion(String actEspecificacion) {
		this.actEspecificacion = actEspecificacion;
	}

	public BigDecimal getActPoderPublico() {
		return this.actPoderPublico;
	}

	public void setActPoderPublico(BigDecimal actPoderPublico) {
		this.actPoderPublico = actPoderPublico;
	}

	public BigDecimal getActPublicoGeneral() {
		return this.actPublicoGeneral;
	}

	public void setActPublicoGeneral(BigDecimal actPublicoGeneral) {
		this.actPublicoGeneral = actPublicoGeneral;
	}

	public BigDecimal getActRecursosPublicos() {
		return this.actRecursosPublicos;
	}

	public void setActRecursosPublicos(BigDecimal actRecursosPublicos) {
		this.actRecursosPublicos = actRecursosPublicos;
	}

	public String getActeconomicaAsegurado() {
		return this.acteconomicaAsegurado;
	}

	public void setActeconomicaAsegurado(String acteconomicaAsegurado) {
		this.acteconomicaAsegurado = acteconomicaAsegurado;
	}

	public BigDecimal getActivos() {
		return this.activos;
	}

	public void setActivos(BigDecimal activos) {
		this.activos = activos;
	}

	public BigDecimal getActivosAs() {
		return this.activosAs;
	}

	public void setActivosAs(BigDecimal activosAs) {
		this.activosAs = activosAs;
	}

	public BigDecimal getActivosPj() {
		return this.activosPj;
	}

	public void setActivosPj(BigDecimal activosPj) {
		this.activosPj = activosPj;
	}

	public BigDecimal getAlertas() {
		return this.alertas;
	}

	public void setAlertas(BigDecimal alertas) {
		this.alertas = alertas;
	}

	public BigDecimal getCalidad() {
		return this.calidad;
	}

	public void setCalidad(BigDecimal calidad) {
		this.calidad = calidad;
	}

	public BigDecimal getCantReprocesos() {
		return this.cantReprocesos;
	}

	public void setCantReprocesos(BigDecimal cantReprocesos) {
		this.cantReprocesos = cantReprocesos;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public BigDecimal getCargosOficiales() {
		return this.cargosOficiales;
	}

	public void setCargosOficiales(BigDecimal cargosOficiales) {
		this.cargosOficiales = cargosOficiales;
	}

	public String getCedulaentrevista() {
		return this.cedulaentrevista;
	}

	public void setCedulaentrevista(String cedulaentrevista) {
		this.cedulaentrevista = cedulaentrevista;
	}

	public String getCelResidencia() {
		return this.celResidencia;
	}

	public void setCelResidencia(String celResidencia) {
		this.celResidencia = celResidencia;
	}

	public String getCiuAsegurado() {
		return this.ciuAsegurado;
	}

	public void setCiuAsegurado(String ciuAsegurado) {
		this.ciuAsegurado = ciuAsegurado;
	}

	public String getCiuResidencia() {
		return this.ciuResidencia;
	}

	public void setCiuResidencia(String ciuResidencia) {
		this.ciuResidencia = ciuResidencia;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCiudadPj() {
		return this.ciudadPj;
	}

	public void setCiudadPj(String ciudadPj) {
		this.ciudadPj = ciudadPj;
	}

	public String getCiudadSucursal() {
		return this.ciudadSucursal;
	}

	public void setCiudadSucursal(String ciudadSucursal) {
		this.ciudadSucursal = ciudadSucursal;
	}

	public int getClasevinculacion() {
		return this.clasevinculacion;
	}

	public void setClasevinculacion(int clasevinculacion) {
		this.clasevinculacion = clasevinculacion;
	}

	public String getClasevinculacioncual() {
		return this.clasevinculacioncual;
	}

	public void setClasevinculacioncual(String clasevinculacioncual) {
		this.clasevinculacioncual = clasevinculacioncual;
	}

	public String getCodCausalDevolucion() {
		return this.codCausalDevolucion;
	}

	public void setCodCausalDevolucion(String codCausalDevolucion) {
		this.codCausalDevolucion = codCausalDevolucion;
	}

	public BigDecimal getComercialEquidad() {
		return this.comercialEquidad;
	}

	public void setComercialEquidad(BigDecimal comercialEquidad) {
		this.comercialEquidad = comercialEquidad;
	}

	public String getConceptoOtrosingresos() {
		return this.conceptoOtrosingresos;
	}

	public void setConceptoOtrosingresos(String conceptoOtrosingresos) {
		this.conceptoOtrosingresos = conceptoOtrosingresos;
	}

	public String getConceptootrosingresosAs() {
		return this.conceptootrosingresosAs;
	}

	public void setConceptootrosingresosAs(String conceptootrosingresosAs) {
		this.conceptootrosingresosAs = conceptootrosingresosAs;
	}

	public String getConceptootrosingresosPj() {
		return this.conceptootrosingresosPj;
	}

	public void setConceptootrosingresosPj(String conceptootrosingresosPj) {
		this.conceptootrosingresosPj = conceptootrosingresosPj;
	}

	public BigDecimal getCuentasmonedaextranjera() {
		return this.cuentasmonedaextranjera;
	}

	public void setCuentasmonedaextranjera(BigDecimal cuentasmonedaextranjera) {
		this.cuentasmonedaextranjera = cuentasmonedaextranjera;
	}

	public BigDecimal getDPrimasSociedad() {
		return this.dPrimasSociedad;
	}

	public void setDPrimasSociedad(BigDecimal dPrimasSociedad) {
		this.dPrimasSociedad = dPrimasSociedad;
	}

	public BigDecimal getDSociedadComercio() {
		return this.dSociedadComercio;
	}

	public void setDSociedadComercio(BigDecimal dSociedadComercio) {
		this.dSociedadComercio = dSociedadComercio;
	}

	public BigDecimal getDeclararenta() {
		return this.declararenta;
	}

	public void setDeclararenta(BigDecimal declararenta) {
		this.declararenta = declararenta;
	}

	public String getDescripcioncalidad() {
		return this.descripcioncalidad;
	}

	public void setDescripcioncalidad(String descripcioncalidad) {
		this.descripcioncalidad = descripcioncalidad;
	}

	public String getDescripciontomadorAsegurado() {
		return this.descripciontomadorAsegurado;
	}

	public void setDescripciontomadorAsegurado(String descripciontomadorAsegurado) {
		this.descripciontomadorAsegurado = descripciontomadorAsegurado;
	}

	public String getDirAsegurado() {
		return this.dirAsegurado;
	}

	public void setDirAsegurado(String dirAsegurado) {
		this.dirAsegurado = dirAsegurado;
	}

	public String getDirResidencia() {
		return this.dirResidencia;
	}

	public void setDirResidencia(String dirResidencia) {
		this.dirResidencia = dirResidencia;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDireccionPj() {
		return this.direccionPj;
	}

	public void setDireccionPj(String direccionPj) {
		this.direccionPj = direccionPj;
	}

	public String getDireccionSucursal() {
		return this.direccionSucursal;
	}

	public void setDireccionSucursal(String direccionSucursal) {
		this.direccionSucursal = direccionSucursal;
	}

	public String getDocFcc() {
		return this.docFcc;
	}

	public void setDocFcc(String docFcc) {
		this.docFcc = docFcc;
	}

	public String getDoc1Fcc() {
		return this.doc1Fcc;
	}

	public void setDoc1Fcc(String doc1Fcc) {
		this.doc1Fcc = doc1Fcc;
	}

	public BigDecimal getEgresos() {
		return this.egresos;
	}

	public void setEgresos(BigDecimal egresos) {
		this.egresos = egresos;
	}

	public BigDecimal getEgresosAs() {
		return this.egresosAs;
	}

	public void setEgresosAs(BigDecimal egresosAs) {
		this.egresosAs = egresosAs;
	}

	public BigDecimal getEgresosPj() {
		return this.egresosPj;
	}

	public void setEgresosPj(BigDecimal egresosPj) {
		this.egresosPj = egresosPj;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailRl() {
		return this.emailRl;
	}

	public void setEmailRl(String emailRl) {
		this.emailRl = emailRl;
	}

	public BigDecimal getEstadoLlamada() {
		return this.estadoLlamada;
	}

	public void setEstadoLlamada(BigDecimal estadoLlamada) {
		this.estadoLlamada = estadoLlamada;
	}

	public BigDecimal getEstadoSoli() {
		return this.estadoSoli;
	}

	public void setEstadoSoli(BigDecimal estadoSoli) {
		this.estadoSoli = estadoSoli;
	}

	public BigDecimal getEstadocivil() {
		return this.estadocivil;
	}

	public void setEstadocivil(BigDecimal estadocivil) {
		this.estadocivil = estadocivil;
	}

	public BigDecimal getEstratoFcc() {
		return this.estratoFcc;
	}

	public void setEstratoFcc(BigDecimal estratoFcc) {
		this.estratoFcc = estratoFcc;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFaxPj() {
		return this.faxPj;
	}

	public void setFaxPj(String faxPj) {
		this.faxPj = faxPj;
	}

	public String getFaxSucursal() {
		return this.faxSucursal;
	}

	public void setFaxSucursal(String faxSucursal) {
		this.faxSucursal = faxSucursal;
	}

	public Date getFechaExpedicion() {
		return this.fechaExpedicion;
	}

	public void setFechaExpedicion(Date fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaentrevista() {
		return this.fechaentrevista;
	}

	public void setFechaentrevista(Date fechaentrevista) {
		this.fechaentrevista = fechaentrevista;
	}

	public Date getFechaexpedicionAsegurado() {
		return this.fechaexpedicionAsegurado;
	}

	public void setFechaexpedicionAsegurado(Date fechaexpedicionAsegurado) {
		this.fechaexpedicionAsegurado = fechaexpedicionAsegurado;
	}

	public Date getFechanacimientoAsegurado() {
		return this.fechanacimientoAsegurado;
	}

	public void setFechanacimientoAsegurado(Date fechanacimientoAsegurado) {
		this.fechanacimientoAsegurado = fechanacimientoAsegurado;
	}

	public String getIdAsegurado() {
		return this.idAsegurado;
	}

	public void setIdAsegurado(String idAsegurado) {
		this.idAsegurado = idAsegurado;
	}

	public BigDecimal getIdSolicitud() {
		return this.idSolicitud;
	}

	public void setIdSolicitud(BigDecimal idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getIdconfirmadatos() {
		return this.idconfirmadatos;
	}

	public void setIdconfirmadatos(String idconfirmadatos) {
		this.idconfirmadatos = idconfirmadatos;
	}

	public String getIdentificacionRl() {
		return this.identificacionRl;
	}

	public void setIdentificacionRl(String identificacionRl) {
		this.identificacionRl = identificacionRl;
	}

	public BigDecimal getIngresos() {
		return this.ingresos;
	}

	public void setIngresos(BigDecimal ingresos) {
		this.ingresos = ingresos;
	}

	public BigDecimal getIngresosAs() {
		return this.ingresosAs;
	}

	public void setIngresosAs(BigDecimal ingresosAs) {
		this.ingresosAs = ingresosAs;
	}

	public BigDecimal getIngresosPj() {
		return this.ingresosPj;
	}

	public void setIngresosPj(BigDecimal ingresosPj) {
		this.ingresosPj = ingresosPj;
	}

	public BigDecimal getInstitucionFinanciera() {
		return this.institucionFinanciera;
	}

	public void setInstitucionFinanciera(BigDecimal institucionFinanciera) {
		this.institucionFinanciera = institucionFinanciera;
	}

	public String getJuridicaRazonsocial() {
		return this.juridicaRazonsocial;
	}

	public void setJuridicaRazonsocial(String juridicaRazonsocial) {
		this.juridicaRazonsocial = juridicaRazonsocial;
	}

	public String getLugarExpedicion() {
		return this.lugarExpedicion;
	}

	public void setLugarExpedicion(String lugarExpedicion) {
		this.lugarExpedicion = lugarExpedicion;
	}

	public String getLugarentrevista() {
		return this.lugarentrevista;
	}

	public void setLugarentrevista(String lugarentrevista) {
		this.lugarentrevista = lugarentrevista;
	}

	public String getLugarexpedicionAsegurado() {
		return this.lugarexpedicionAsegurado;
	}

	public void setLugarexpedicionAsegurado(String lugarexpedicionAsegurado) {
		this.lugarexpedicionAsegurado = lugarexpedicionAsegurado;
	}

	public String getLugaryfechaexpRl() {
		return this.lugaryfechaexpRl;
	}

	public void setLugaryfechaexpRl(String lugaryfechaexpRl) {
		this.lugaryfechaexpRl = lugaryfechaexpRl;
	}

	public BigDecimal getMonedaextranjera() {
		return this.monedaextranjera;
	}

	public void setMonedaextranjera(BigDecimal monedaextranjera) {
		this.monedaextranjera = monedaextranjera;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNacionalidadRl() {
		return this.nacionalidadRl;
	}

	public void setNacionalidadRl(String nacionalidadRl) {
		this.nacionalidadRl = nacionalidadRl;
	}

	public String getNacionalidad2() {
		return this.nacionalidad2;
	}

	public void setNacionalidad2(String nacionalidad2) {
		this.nacionalidad2 = nacionalidad2;
	}

	public String getNacionalidad2Rl() {
		return this.nacionalidad2Rl;
	}

	public void setNacionalidad2Rl(String nacionalidad2Rl) {
		this.nacionalidad2Rl = nacionalidad2Rl;
	}

	public String getNit() {
		return this.nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNombreCargo() {
		return this.nombreCargo;
	}

	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}

	public String getNombreComercial() {
		return this.nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getNombreConfirmadatos() {
		return this.nombreConfirmadatos;
	}

	public void setNombreConfirmadatos(String nombreConfirmadatos) {
		this.nombreConfirmadatos = nombreConfirmadatos;
	}

	public String getNombreEmpresa() {
		return this.nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getNombreInstitucion() {
		return this.nombreInstitucion;
	}

	public void setNombreInstitucion(String nombreInstitucion) {
		this.nombreInstitucion = nombreInstitucion;
	}

	public String getNombreSeguros() {
		return this.nombreSeguros;
	}

	public void setNombreSeguros(String nombreSeguros) {
		this.nombreSeguros = nombreSeguros;
	}

	public String getNombreentrevista() {
		return this.nombreentrevista;
	}

	public void setNombreentrevista(String nombreentrevista) {
		this.nombreentrevista = nombreentrevista;
	}

	public String getNumeroIdentificacion() {
		return this.numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public BigDecimal getNumerohijos() {
		return this.numerohijos;
	}

	public void setNumerohijos(BigDecimal numerohijos) {
		this.numerohijos = numerohijos;
	}

	public String getObjetoSocial() {
		return this.objetoSocial;
	}

	public void setObjetoSocial(String objetoSocial) {
		this.objetoSocial = objetoSocial;
	}

	public BigDecimal getObligacionesOtropais() {
		return this.obligacionesOtropais;
	}

	public void setObligacionesOtropais(BigDecimal obligacionesOtropais) {
		this.obligacionesOtropais = obligacionesOtropais;
	}

	public String getObligacionesOtropaisDesc() {
		return this.obligacionesOtropaisDesc;
	}

	public void setObligacionesOtropaisDesc(String obligacionesOtropaisDesc) {
		this.obligacionesOtropaisDesc = obligacionesOtropaisDesc;
	}

	public String getObservacionconfirmadatos() {
		return this.observacionconfirmadatos;
	}

	public void setObservacionconfirmadatos(String observacionconfirmadatos) {
		this.observacionconfirmadatos = observacionconfirmadatos;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getOcupacion() {
		return this.ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getOtroMonedaextranjera() {
		return this.otroMonedaextranjera;
	}

	public void setOtroMonedaextranjera(String otroMonedaextranjera) {
		this.otroMonedaextranjera = otroMonedaextranjera;
	}

	public BigDecimal getOtrosIngresos() {
		return this.otrosIngresos;
	}

	public void setOtrosIngresos(BigDecimal otrosIngresos) {
		this.otrosIngresos = otrosIngresos;
	}

	public BigDecimal getOtrosingresosAs() {
		return this.otrosingresosAs;
	}

	public void setOtrosingresosAs(BigDecimal otrosingresosAs) {
		this.otrosingresosAs = otrosingresosAs;
	}

	public BigDecimal getOtrosingresosPj() {
		return this.otrosingresosPj;
	}

	public void setOtrosingresosPj(BigDecimal otrosingresosPj) {
		this.otrosingresosPj = otrosingresosPj;
	}

	public String getPaginaWebPj() {
		return this.paginaWebPj;
	}

	public void setPaginaWebPj(String paginaWebPj) {
		this.paginaWebPj = paginaWebPj;
	}

	public BigDecimal getPasivos() {
		return this.pasivos;
	}

	public void setPasivos(BigDecimal pasivos) {
		this.pasivos = pasivos;
	}

	public BigDecimal getPasivosAs() {
		return this.pasivosAs;
	}

	public void setPasivosAs(BigDecimal pasivosAs) {
		this.pasivosAs = pasivosAs;
	}

	public BigDecimal getPasivosPj() {
		return this.pasivosPj;
	}

	public void setPasivosPj(BigDecimal pasivosPj) {
		this.pasivosPj = pasivosPj;
	}

	public int getPep() {
		return this.pep;
	}

	public void setPep(int pep) {
		this.pep = pep;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getPrimerNombre() {
		return this.primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getPrimerNombreRl() {
		return this.primerNombreRl;
	}

	public void setPrimerNombreRl(String primerNombreRl) {
		this.primerNombreRl = primerNombreRl;
	}

	public String getPrimerapellidoAsegurado() {
		return this.primerapellidoAsegurado;
	}

	public void setPrimerapellidoAsegurado(String primerapellidoAsegurado) {
		this.primerapellidoAsegurado = primerapellidoAsegurado;
	}

	public String getPrimerapellidoRl() {
		return this.primerapellidoRl;
	}

	public void setPrimerapellidoRl(String primerapellidoRl) {
		this.primerapellidoRl = primerapellidoRl;
	}

	public String getPrimernombreAsegurado() {
		return this.primernombreAsegurado;
	}

	public void setPrimernombreAsegurado(String primernombreAsegurado) {
		this.primernombreAsegurado = primernombreAsegurado;
	}

	public BigDecimal getProductosexterior() {
		return this.productosexterior;
	}

	public void setProductosexterior(BigDecimal productosexterior) {
		this.productosexterior = productosexterior;
	}

	public String getProvienenRecursos() {
		return this.provienenRecursos;
	}

	public void setProvienenRecursos(String provienenRecursos) {
		this.provienenRecursos = provienenRecursos;
	}

	public BigDecimal getRPrimasSociedad() {
		return this.rPrimasSociedad;
	}

	public void setRPrimasSociedad(BigDecimal rPrimasSociedad) {
		this.rPrimasSociedad = rPrimasSociedad;
	}

	public BigDecimal getRSociedadComercio() {
		return this.rSociedadComercio;
	}

	public void setRSociedadComercio(BigDecimal rSociedadComercio) {
		this.rSociedadComercio = rSociedadComercio;
	}

	public BigDecimal getRefComercial() {
		return this.refComercial;
	}

	public void setRefComercial(BigDecimal refComercial) {
		this.refComercial = refComercial;
	}

	public int getResultado() {
		return this.resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getSegundoapellidoAsegurado() {
		return this.segundoapellidoAsegurado;
	}

	public void setSegundoapellidoAsegurado(String segundoapellidoAsegurado) {
		this.segundoapellidoAsegurado = segundoapellidoAsegurado;
	}

	public String getSegundoapellidoRl() {
		return this.segundoapellidoRl;
	}

	public void setSegundoapellidoRl(String segundoapellidoRl) {
		this.segundoapellidoRl = segundoapellidoRl;
	}

	public String getSegundonombreAsegurado() {
		return this.segundonombreAsegurado;
	}

	public void setSegundonombreAsegurado(String segundonombreAsegurado) {
		this.segundonombreAsegurado = segundonombreAsegurado;
	}

	public String getSegundonombreRl() {
		return this.segundonombreRl;
	}

	public void setSegundonombreRl(String segundonombreRl) {
		this.segundonombreRl = segundonombreRl;
	}

	public BigDecimal getSegurosCapitalizacion() {
		return this.segurosCapitalizacion;
	}

	public void setSegurosCapitalizacion(BigDecimal segurosCapitalizacion) {
		this.segurosCapitalizacion = segurosCapitalizacion;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public String getSiniestro() {
		return this.siniestro;
	}

	public void setSiniestro(String siniestro) {
		this.siniestro = siniestro;
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

	public String getSucur() {
		return this.sucur;
	}

	public void setSucur(String sucur) {
		this.sucur = sucur;
	}

	public String getTelResidencia() {
		return this.telResidencia;
	}

	public void setTelResidencia(String telResidencia) {
		this.telResidencia = telResidencia;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefonoAsegurado() {
		return this.telefonoAsegurado;
	}

	public void setTelefonoAsegurado(String telefonoAsegurado) {
		this.telefonoAsegurado = telefonoAsegurado;
	}

	public String getTelefonoPj() {
		return this.telefonoPj;
	}

	public void setTelefonoPj(String telefonoPj) {
		this.telefonoPj = telefonoPj;
	}

	public String getTelefonoSucursal() {
		return this.telefonoSucursal;
	}

	public void setTelefonoSucursal(String telefonoSucursal) {
		this.telefonoSucursal = telefonoSucursal;
	}

	public BigDecimal getTipoEmpresa() {
		return this.tipoEmpresa;
	}

	public void setTipoEmpresa(BigDecimal tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	public BigDecimal getTipoFcc() {
		return this.tipoFcc;
	}

	public void setTipoFcc(BigDecimal tipoFcc) {
		this.tipoFcc = tipoFcc;
	}

	public BigDecimal getTipoMonedaextranjera() {
		return this.tipoMonedaextranjera;
	}

	public void setTipoMonedaextranjera(BigDecimal tipoMonedaextranjera) {
		this.tipoMonedaextranjera = tipoMonedaextranjera;
	}

	public String getTipoProducto() {
		return this.tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public BigDecimal getTipoSociedad() {
		return this.tipoSociedad;
	}

	public void setTipoSociedad(BigDecimal tipoSociedad) {
		this.tipoSociedad = tipoSociedad;
	}

	public String getTipoSociedadOtra() {
		return this.tipoSociedadOtra;
	}

	public void setTipoSociedadOtra(String tipoSociedadOtra) {
		this.tipoSociedadOtra = tipoSociedadOtra;
	}

	public int getTipoactividad() {
		return tipoactividad;
	}

	public void setTipoactividad(int tipoactividad) {
		this.tipoactividad = tipoactividad;
	}

	public BigDecimal getTipodocumentoRl() {
		return this.tipodocumentoRl;
	}

	public void setTipodocumentoRl(BigDecimal tipodocumentoRl) {
		this.tipodocumentoRl = tipodocumentoRl;
	}

	public BigDecimal getTipoidentificacion() {
		return this.tipoidentificacion;
	}

	public void setTipoidentificacion(BigDecimal tipoidentificacion) {
		this.tipoidentificacion = tipoidentificacion;
	}

	public BigDecimal getTipoidentificacionAsegurado() {
		return this.tipoidentificacionAsegurado;
	}

	public void setTipoidentificacionAsegurado(BigDecimal tipoidentificacionAsegurado) {
		this.tipoidentificacionAsegurado = tipoidentificacionAsegurado;
	}

	public BigDecimal getTipopersona() {
		return this.tipopersona;
	}

	public void setTipopersona(BigDecimal tipopersona) {
		this.tipopersona = tipopersona;
	}

	public BigDecimal getTipopolizaFcc() {
		return this.tipopolizaFcc;
	}

	public void setTipopolizaFcc(BigDecimal tipopolizaFcc) {
		this.tipopolizaFcc = tipopolizaFcc;
	}

	public BigDecimal getTiporegimen() {
		return this.tiporegimen;
	}

	public void setTiporegimen(BigDecimal tiporegimen) {
		this.tiporegimen = tiporegimen;
	}

	public BigDecimal getTipovinculacion1() {
		return this.tipovinculacion1;
	}

	public void setTipovinculacion1(BigDecimal tipovinculacion1) {
		this.tipovinculacion1 = tipovinculacion1;
	}

	public BigDecimal getTipovinculacion2() {
		return this.tipovinculacion2;
	}

	public void setTipovinculacion2(BigDecimal tipovinculacion2) {
		this.tipovinculacion2 = tipovinculacion2;
	}

	public BigDecimal getTipovinculacion3() {
		return this.tipovinculacion3;
	}

	public void setTipovinculacion3(BigDecimal tipovinculacion3) {
		this.tipovinculacion3 = tipovinculacion3;
	}

	public BigDecimal getTipovinculacion4() {
		return this.tipovinculacion4;
	}

	public void setTipovinculacion4(BigDecimal tipovinculacion4) {
		this.tipovinculacion4 = tipovinculacion4;
	}

	public BigDecimal getVinPep() {
		return this.vinPep;
	}

	public void setVinPep(BigDecimal vinPep) {
		this.vinPep = vinPep;
	}

	public String getVinPepDescripcion() {
		return this.vinPepDescripcion;
	}

	public void setVinPepDescripcion(String vinPepDescripcion) {
		this.vinPepDescripcion = vinPepDescripcion;
	}

	public BigDecimal getVinculos() {
		return this.vinculos;
	}

	public void setVinculos(BigDecimal vinculos) {
		this.vinculos = vinculos;
	}

}