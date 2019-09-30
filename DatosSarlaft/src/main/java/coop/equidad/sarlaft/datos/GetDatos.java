package coop.equidad.sarlaft.datos;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import coop.equidad.sarlaft.cache.CacheActividadEconomica;
import coop.equidad.sarlaft.cache.CacheCiudad;
import coop.equidad.sarlaft.cache.CacheCodigosEquidad;
import coop.equidad.sarlaft.constante.CONSTANTES;
import coop.equidad.sarlaft.entidades.BodyRequest;
import coop.equidad.sarlaft.entidades.PropuestaSarlaftPK;
import coop.equidad.sarlaft.entidades.Propuestassarlaft;
import coop.equidad.sarlaft.entidades.ResponseSarlaft;
import coop.equidad.sarlaft.entidades.S03105;
import coop.equidad.sarlaft.entidades.S03502;
import coop.equidad.sarlaft.entidades.S03502PK;
import coop.equidad.sarlaft.entidades.S03sarlaft;
import coop.equidad.sarlaft.entidades.S03sarlaftInversiones;
import coop.equidad.sarlaft.entidades.S03sarlaftPK;
import coop.equidad.sarlaft.entidades.S03sarlaftReclamaciones;
import coop.equidad.sarlaft.entidades.SarlaftHomTablasFalabella;
import coop.equidad.sarlaft.repository.*;
import org.slf4j.LoggerFactory;

@Service
public class GetDatos {

	@Autowired
	CotizacionesRepository cotizacionesRepository;
	@Autowired
	SarlaftRepository sarlaftRepository;
	@Autowired
	SarlaftProceRepository sarlaftProceRepository;
	@Autowired
	SarlaftInversiones sarlaftInversiones;
	@Autowired
	SarlaftReclamaciones sarlaftReclamaciones;
	@Autowired
	CacheCodigosEquidad cacheCodigosEquidad;
	@Autowired
	CacheActividadEconomica actividadEconomica;
	@Autowired
	CacheCiudad cacheCiudad;
	@Autowired
	PropuestaSarlaftRepository propuestaSarlaftRepository;
	@Autowired
	SarlaftRepository repository;
	@Autowired
	S03502Repository s03502Repository;

	org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

	S03sarlaft s03sarlaft = new S03sarlaft();
	S03sarlaftPK s03sarlaftPK = new S03sarlaftPK();
	S03sarlaftInversiones s03sarlaftInversiones = new S03sarlaftInversiones();
	S03sarlaftReclamaciones s03sarlaftReclamaciones = new S03sarlaftReclamaciones();
	Propuestassarlaft propuestassarlaft = new Propuestassarlaft();
	PropuestaSarlaftPK propuestaSarlaftPK = new PropuestaSarlaftPK();

	@Scheduled(fixedDelay = 20000)
	@Async("nombreBean")
	public void Lista2() throws ParseException {

		Boolean validacion = true;

		List<String> listaPrueba = new ArrayList<>();
		listaPrueba.add("10003897");
		listaPrueba.add("10003877");
		/**
		 * Iterable<Cotizaciones> listaCotizadores = cotizacionesRepository.findAll();
		 */

		for (String listaPruebas : listaPrueba) {

			/**
			 * for (Cotizaciones cotizaciones : listaCotizadores) {
			 * System.out.println("numero " + cotizaciones.getValstring());
			 * 
			 */

			RestTemplate restTemplate1 = new RestTemplate();
			BodyRequest bodyRequest = new BodyRequest();
			bodyRequest.setNumPropuesta(Long.parseLong((listaPruebas)));
			String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiIyMiJ9.5CEXRt34lCR_T2gN7LM1_Sv2lcUu5m8NQCMHqwTqU-M";

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.add("Authorization", "Bearer " + token);
			HttpEntity<BodyRequest> request = new HttpEntity<>(bodyRequest, headers);

			ResponseEntity<ResponseSarlaft> response = restTemplate1.exchange(
					"https://api.staging.segurosfalabella.cloud/api-datos-dinamicos-sarlaft/getDataSarlaft",
					HttpMethod.POST, request, ResponseSarlaft.class);

			listaDatos(response.getBody().getData().getNumeroPropuesta(), response.getBody().getStatus(),
					response.getBody().getMessage());
			if (validarRevision(s03sarlaft.getId().getCodigo())) {
				if (response.getBody().getStatus().equalsIgnoreCase(CONSTANTES.CODIGO_EXITO)) {
					for (int i = 0; i < response.getBody().getData().getBien().getContratante().size(); i++) {
						String codigo = "";
						try {
							codigo = response.getBody().getData().getBien().getContratante().get(i)
									.getAdditionalProperties().get("codigo").toString();

							String valor = response.getBody().getData().getBien().getContratante().get(i)
									.getAdditionalProperties().get("valor").toString();

							switch (codigo) {
							case CONSTANTES.CT_ACT_ECONOMICA:
								while (valor.length() < 4) {
									valor = "0" + valor;
								}
								List<S03105> lista = actividadEconomica
										.getCodigosActividad(CONSTANTES.CODIGO_DETALLE_ACTI);
								String act = obtenerValorActividad(lista, valor);
								s03sarlaft.setActEconomica(act);
								break;

							case CONSTANTES.CT_INGRESOS:
								if (!valor.isEmpty()) {
									s03sarlaft.setIngresos(new BigDecimal(valor));
								} else {
									s03sarlaft.setIngresos(null);
								}
								break;

							case CONSTANTES.CT_ACTIVOS:
								if (!valor.isEmpty()) {
									s03sarlaft.setActivos(new BigDecimal(valor));
								} else {
									s03sarlaft.setActivos(null);
								}
								break;
							case CONSTANTES.CT_EGRESOS:
								if (!valor.isEmpty()) {
									s03sarlaft.setEgresos(new BigDecimal(valor));
								} else {
									s03sarlaft.setEgresos(null);
								}
								break;
							case CONSTANTES.CT_PASIVOS:
								if (!valor.isEmpty()) {
									s03sarlaft.setPasivos(new BigDecimal(valor));
								} else {
									s03sarlaft.setPasivos(null);
								}
								break;
							case CONSTANTES.CT_OTROS_INGRESOS:
								if (!valor.isEmpty()) {
									s03sarlaft.setOtrosIngresos(new BigDecimal(valor));
								} else {
									s03sarlaft.setOtrosIngresos(null);
								}
								break;
							case CONSTANTES.CT_CONCEPTO_OTROS_INGRESOS:
								if (!valor.isEmpty()) {
									s03sarlaft.setConceptoOtrosingresos(valor);
								} else {
									s03sarlaft.setConceptoOtrosingresos(null);
								}
								break;
							case CONSTANTES.CT_ACT_RECURSOS_PUBLICOS:
								if (!valor.isEmpty()) {
									List<SarlaftHomTablasFalabella> listaCodigos = cacheCodigosEquidad
											.getCodigosEquidad();
									s03sarlaft.setActRecursosPublicos(
											new BigDecimal(obtenerValorCodigoEquidad(listaCodigos, valor, codigo)));
								} else {
									s03sarlaft.setActRecursosPublicos(null);
								}
								break;
							case CONSTANTES.CT_RECONOCIMIENTO_PUBLICO_GENRAL:
								if (!valor.isEmpty()) {
									List<SarlaftHomTablasFalabella> listaCodigos = cacheCodigosEquidad
											.getCodigosEquidad();
									s03sarlaft.setActPublicoGeneral(
											new BigDecimal(obtenerValorCodigoEquidad(listaCodigos, valor, codigo)));
								} else {
									s03sarlaft.setActPublicoGeneral(null);
								}
								break;
							case CONSTANTES.CT_RESPUESTA_AFIRMATIVA_1:
								if (!valor.isEmpty()) {
									s03sarlaft.setActEspecificacion(valor);
								} else {
									s03sarlaft.setActEspecificacion(null);
								}
								break;
							case CONSTANTES.CT_OPERACION_MONEDA:
								if (!valor.isEmpty()) {
									List<SarlaftHomTablasFalabella> listaCodigos = cacheCodigosEquidad
											.getCodigosEquidad();
									s03sarlaft.setMonedaextranjera(
											new BigDecimal(obtenerValorCodigoEquidad(listaCodigos, valor, codigo)));
								} else {
									s03sarlaft.setMonedaextranjera(null);
								}
								break;
							case CONSTANTES.CT_OPERACION_EXTRANGERA:
								if (!valor.trim().isEmpty()) {
									List<SarlaftHomTablasFalabella> listaCodigos = cacheCodigosEquidad
											.getCodigosEquidad();
									s03sarlaft.setTipoMonedaextranjera(
											new BigDecimal(obtenerValorCodigoEquidad(listaCodigos, valor, codigo)));
								} else {
									s03sarlaft.setTipoMonedaextranjera(new BigDecimal("0"));
								}
								break;
							case CONSTANTES.CT_PRODUCTOS_EXTERIOR:
								if (!valor.isEmpty()) {
									List<SarlaftHomTablasFalabella> listaCodigos = cacheCodigosEquidad
											.getCodigosEquidad();
									s03sarlaft.setProductosexterior(
											new BigDecimal(obtenerValorCodigoEquidad(listaCodigos, valor, codigo)));
								} else {
									s03sarlaft.setProductosexterior(null);
								}
								break;
							case CONSTANTES.CT_TIPO_PRODUCTO:
								if (!valor.isEmpty()) {
									s03sarlaftInversiones.setTipoProductoInver(valor);
								} else {
									s03sarlaftInversiones.setTipoProductoInver(null);
								}
								break;
							case CONSTANTES.CT_NUMERO_PRODUCTO:
								if (!valor.isEmpty()) {
									s03sarlaftInversiones.setIndentificacionInver(valor);
								} else {
									s03sarlaftInversiones.setIndentificacionInver(null);
								}
								break;
							case CONSTANTES.CT_ENTIDAD:
								if (!valor.isEmpty()) {
									s03sarlaftInversiones.setEntidadInver(valor);
								} else {
									s03sarlaftInversiones.setEntidadInver(null);
								}
								break;
							case CONSTANTES.CT_MONTO:
								if (!valor.trim().isEmpty()) {
									s03sarlaftInversiones.setMontoInver(new BigDecimal(valor));
								} else {
									s03sarlaftInversiones.setMontoInver(new BigDecimal("0"));
								}
								break;
							case CONSTANTES.CT_PAIS:
								if (!valor.isEmpty()) {
									List<SarlaftHomTablasFalabella> listaCodigos = cacheCodigosEquidad
											.getCodigosEquidad();
									s03sarlaftInversiones
											.setPaisInver(obtenerValorCodigoEquidad(listaCodigos, valor, codigo));

									s03sarlaftInversiones.setCiudadInver(s03sarlaftInversiones.getPaisInver());
								} else {
									s03sarlaftInversiones.setPaisInver(null);
									s03sarlaftReclamaciones.setCiudadInver(null);
								}
								break;
							case CONSTANTES.CT_MONEDA:
								if (!valor.isEmpty()) {
									s03sarlaftInversiones.setMonedaInver(Integer.parseInt("0"));
								} else {
									s03sarlaftInversiones.setMonedaInver(0);
								}
								break;
							case CONSTANTES.CT_TELEFONO:
								if (!valor.isEmpty()) {
									s03sarlaft.setTelefono(valor);
								} else {
									s03sarlaft.setTelefono(null);
								}
								break;
							case CONSTANTES.CT_VINCULO_PUBLICAMENTE:
								s03sarlaft.setVinculos(new BigDecimal("1"));
								break;

							case CONSTANTES.CT_RESPUESTA_AFIRMATIVA_2:
								if (!valor.isEmpty()) {
									String respuesta = "";
									respuesta = s03sarlaft.getActEspecificacion().isEmpty() ? valor
											: s03sarlaft.getActEspecificacion() + " ; " + valor;
									s03sarlaft.setActEspecificacion(respuesta);
								}
								break;
							case CONSTANTES.CT_OCUPACION:
								if (!valor.isEmpty()) {
									List<SarlaftHomTablasFalabella> listaCodigos = cacheCodigosEquidad
											.getCodigosEquidad();
									s03sarlaft.setOcupacion(obtenerValorCodigoEquidad(listaCodigos, valor, codigo));
									s03sarlaft.setCargo(s03sarlaft.getOcupacion());
								} else {
									s03sarlaft.setOcupacion(null);
								}
								break;
							case CONSTANTES.CT_NOMBRE_EMPRESA:
								if (!valor.isEmpty()) {
									s03sarlaft.setNombreEmpresa(valor);
								} else {
									s03sarlaft.setNombreEmpresa(null);
								}
								break;
							case CONSTANTES.CT_DIRECCION:
								if (!valor.isEmpty()) {
									s03sarlaft.setDireccion(valor);
								} else {
									s03sarlaft.setDireccion(null);
								}
								break;

							case CONSTANTES.CT_CIUDAD:
								if (!valor.isEmpty()) {
									String valor22 = valor;
									while (valor22.length() < 5) {
										valor22 = "0" + valor22;
									}
									List<S03105> listaCiudad = cacheCiudad
											.getCodigosCiudad(CONSTANTES.CODIGO_DETALLE_CIUD);
									s03sarlaft.setCiudad(obtenerValorCiudad(listaCiudad, valor22));
								} else {
									s03sarlaft.setCiudad(null);
								}
								break;
							case CONSTANTES.CT_SINIESTRO:
								if (!valor.isEmpty()) {
									List<SarlaftHomTablasFalabella> listaCodigos = cacheCodigosEquidad
											.getCodigosEquidad();
									s03sarlaft.setSiniestro(obtenerValorCodigoEquidad(listaCodigos, valor, codigo));
								} else {
									s03sarlaft.setSiniestro(null);
								}
								break;
							case CONSTANTES.CT_COMPANIA_RAMO:
								if (s03sarlaft.getSiniestro().equalsIgnoreCase("1")) {
									String[] datosReclamacion = valor.replaceAll("[\\-\\+\\.\\^:,]", "").split(" ");
									s03sarlaftReclamaciones.setTipoProductoInver(datosReclamacion[3]);
									s03sarlaftReclamaciones.setIndentificacionInver(datosReclamacion[1]);
									s03sarlaftReclamaciones.setEntidadInver(datosReclamacion[2]);
									s03sarlaftReclamaciones.setMontoInver(BigDecimal.ONE);
									s03sarlaftReclamaciones.setCiudadInver(datosReclamacion[4]);
								} else {
									s03sarlaftReclamaciones.setTipoProductoInver("0");
									s03sarlaftReclamaciones.setIndentificacionInver("0");
									s03sarlaftReclamaciones.setEntidadInver("0");
									s03sarlaftReclamaciones.setMontoInver(BigDecimal.ZERO);
									s03sarlaftReclamaciones.setCiudadInver("0");
								}
								break;
							case CONSTANTES.CT_VINCULO_CON_ASEGURADO:
								s03sarlaft.setTipovinculacion1(new BigDecimal("2"));
								break;
							case CONSTANTES.CT_NACIONALIDAD:
								if (!valor.isEmpty()) {
									List<SarlaftHomTablasFalabella> listaCodigos = cacheCodigosEquidad
											.getCodigosEquidad();
									s03sarlaft.setNacionalidad(obtenerValorCodigoEquidad(listaCodigos, valor, codigo));
								} else {
									s03sarlaft.setNacionalidad(null);
								}
								break;
							case CONSTANTES.CT_ESTADO_CIVIL:
								if (!valor.isEmpty()) {
									List<SarlaftHomTablasFalabella> listaCodigos = cacheCodigosEquidad
											.getCodigosEquidad();
									s03sarlaft.setEstadocivil(
											new BigDecimal(obtenerValorCodigoEquidad(listaCodigos, valor, codigo)));
								} else {
									s03sarlaft.setEstadocivil(null);
								}
								break;
							case CONSTANTES.CT_GRADO_PODER:
								if (!valor.isEmpty()) {
									List<SarlaftHomTablasFalabella> listaCodigos = cacheCodigosEquidad
											.getCodigosEquidad();
									s03sarlaft.setActPoderPublico(
											new BigDecimal(obtenerValorCodigoEquidad(listaCodigos, valor, codigo)));
								} else {
									s03sarlaft.setActPoderPublico(null);
								}
								break;
							}
						} catch (Exception e) {
							String mensajePersonal = "Se produjo un error en el codigo No. " + codigo;
							String mensajeEstado = response.getBody().getStatus()
									+ ": El error se presenta por un dato";
							insertPropuestas(listaPruebas, mensajeEstado, e.toString(), mensajePersonal);
							validacion = false;
						}
					}
					insertarTodoDato(validacion, listaPruebas, response.getBody().getStatus());
				}
			} else {
				String mensajeEstado = response.getBody().getStatus() + ": El error se presenta por vigencia";
				insertPropuestas(listaPruebas, mensajeEstado,
						"Se produjo una excepcion debido a que la propuesta sigue vigente",
						"Revisar que tenga mas de un año");
			}

		}
	}

	public Boolean listaDatos(String valor, String estado, String mensaje) throws ParseException {

		try {

			if (estado.equalsIgnoreCase(CONSTANTES.CODIGO_EXITO)) {
				SimpleDateFormat formatoDate = new SimpleDateFormat(CONSTANTES.FORMATO_FECHA);
				String procedimiento = sarlaftProceRepository.datosPerson(valor);
				procedimiento = procedimiento + "FINAL";
				String[] parts = procedimiento.split("\\|");

				s03sarlaft.setPrimerNombre(parts[1]);
				if (parts[1].isEmpty()) {
					s03sarlaft.setPrimerNombre(parts[0]);
				}

				s03sarlaftPK.setFecvincula(new Date());
				s03sarlaftPK.setCodigo(parts[5]);
				s03sarlaft.setId(s03sarlaftPK);
				s03sarlaft.setSegundoNombre(parts[2]);
				s03sarlaft.setPrimerApellido(parts[3]);
				s03sarlaft.setSegundoNombre(parts[4]);
				s03sarlaft.setNumeroIdentificacion(parts[5]);
				s03sarlaft.setTipoidentificacion(BigDecimal.ONE);
				s03sarlaft.setLugarExpedicion(parts[7]);
				Date fechaExpe = null;
				Date fechaNaci = null;
				if (!parts[8].equals("")) {
					fechaExpe = formatoDate.parse(parts[8]);
				}
				if (!parts[9].equals("")) {
					fechaNaci = formatoDate.parse(parts[9]);
				}
				s03sarlaft.setFechaExpedicion(fechaExpe);
				s03sarlaft.setFechaNacimiento(fechaNaci);
				s03sarlaft.setSexo(Integer.parseInt(parts[10]));
				s03sarlaft.setDirResidencia(parts[12]);
				List<S03105> listaCiudad = cacheCiudad.getCodigosCiudad(CONSTANTES.CODIGO_DETALLE_CIUD);
				s03sarlaft.setCiuResidencia(obtenerValorCiudad(listaCiudad, parts[13]));
				s03sarlaft.setTelResidencia(parts[14]);
				s03sarlaft.setCelResidencia(parts[15]);
				s03sarlaft.setEmail(parts[16]);
				s03sarlaft.setNumerohijos(parts[17].equals("") ? BigDecimal.ZERO : new BigDecimal(parts[17]));
				s03sarlaft.setProvienenRecursos(parts[18]);
				s03sarlaft.setSucur(parts[19]);
				s03sarlaft.setLugarentrevista(parts[19]);
				s03sarlaftInversiones.setCodigoInver(parts[5]);
				s03sarlaftInversiones.setFechaVinculacionInver(new Date());
				s03sarlaftReclamaciones.setCodigoInver(parts[5]);
				s03sarlaftReclamaciones.setFechaVinculacionInver(new Date());
				s03sarlaftReclamaciones.setFechaVinculacionInver(new Date());
				propuestaSarlaftPK.setCodigo(parts[5]);
				System.out.println("CEDULA PERSONA " + s03sarlaft.getId().getCodigo());
			} else {
				String mensajePersonalizado = "La propuesta no tiene datos";
				insertPropuestas(valor, "Error", mensaje, mensajePersonalizado);
			}
		} catch (NumberFormatException e) {
			String errorLe = e.toString();
			String mensajePersonalizado = "Se produjo un error al buscar la informacion personal de la propuesta";
			String mensajeEstado = estado + ": El error se presenta al buscar los datos personales";
			insertPropuestas(valor, mensajeEstado, errorLe, mensajePersonalizado);
		}

		return true;
	}

	public String obtenerValorActividad(List<S03105> lista, String valor) {
		String codigoDeEquidad = null;
		if (!lista.isEmpty()) {
			for (S03105 s03105 : lista) {
				if (s03105.getCodigo().equals(valor)) {
					codigoDeEquidad = s03105.getNombre();
					break;
				}
			}
		}
		return codigoDeEquidad;
	}

	public String obtenerValorCiudad(List<S03105> lista, String valor) {
		String codigoValorCiudad = null;
		if (!lista.isEmpty()) {
			for (S03105 s03105 : lista) {
				if (s03105.getCodigo().equals(valor)) {
					codigoValorCiudad = s03105.getNombre();
					break;
				}
			}
		}
		return codigoValorCiudad;
	}

	public String obtenerValorCodigoEquidad(List<SarlaftHomTablasFalabella> listaEquidad, String valor, String codigo) {
		String codigoDeEquidad = null;
		if (!listaEquidad.isEmpty()) {
			for (SarlaftHomTablasFalabella sarlaft : listaEquidad) {
				if (sarlaft.getId().getCodigoFalabella().equals(valor)
						&& sarlaft.getId().getTipo_Table() == Integer.parseInt(codigo)) {
					codigoDeEquidad = sarlaft.getCodigoEquidad();
					break;
				}
			}
		}
		return codigoDeEquidad;
	}

	public Boolean insertPropuestas(String propuesta, String estado, String mensaje, String mensajePersonal) {
		Boolean agrego = true;
		try {
			Calendar ahoraCal2 = Calendar.getInstance();
			ahoraCal2.setTime(new Date());
			ahoraCal2.add(Calendar.DATE, 360);

			propuestaSarlaftPK.setFecinicio(new Date());
			propuestaSarlaftPK.setPropuesta(propuesta);
			propuestassarlaft.setId(propuestaSarlaftPK);
			propuestassarlaft.setEstado(estado);
			propuestassarlaft.setFecfin(ahoraCal2.getTime());
			propuestassarlaft.setMensaje1(mensaje);
			propuestassarlaft.setMensaje(mensajePersonal);
			propuestaSarlaftRepository.save(propuestassarlaft);

			insertS03502(ahoraCal2.getTime());

		} catch (Exception e) {
			agrego = false;
		}
		return agrego;
	}

	public Boolean validarRevision(String codigo) {
		List<Propuestassarlaft> propuestaAnteriores = propuestaSarlaftRepository.buscarPropuesta(codigo,
				CONSTANTES.BUSCA_PROPUESTA_ESTADO);
		Boolean validacion = true;
		if (!propuestaAnteriores.isEmpty()) {
			validacion = false;
		}
		return validacion;
	}

	int primerDatos;
	int segundoDatos;

	public void insertarTodoDato(Boolean validacion, String valor, String estado) {
		try {
			if (validacion) {

				s03sarlaft.setTipopersona(BigDecimal.ONE);
				s03sarlaft.setId(s03sarlaftPK);
				primerDatos = sarlaftRepository.insertSarlaft(s03sarlaft.getActEconomica(), s03sarlaft.getIngresos(),
						s03sarlaft.getActivos(), s03sarlaft.getEgresos(), s03sarlaft.getPasivos(),
						s03sarlaft.getOtrosIngresos(), s03sarlaft.getConceptoOtrosingresos(),
						s03sarlaft.getActRecursosPublicos(), s03sarlaft.getActPublicoGeneral(),
						s03sarlaft.getMonedaextranjera(), s03sarlaft.getId().getCodigo(),
						s03sarlaft.getId().getFecvincula(), s03sarlaft.getTipoMonedaextranjera(),
						s03sarlaft.getProductosexterior(), s03sarlaft.getTelefono(), s03sarlaft.getVinculos(),
						s03sarlaft.getOcupacion(), s03sarlaft.getNombreEmpresa(), s03sarlaft.getDireccion(),
						s03sarlaft.getCiudad(), s03sarlaft.getSiniestro(), s03sarlaft.getTipovinculacion1(),
						s03sarlaft.getNacionalidad(), s03sarlaft.getEstadocivil(), s03sarlaft.getTipopersona(),
						s03sarlaft.getPrimerNombre(), s03sarlaft.getPrimerApellido(), s03sarlaft.getSegundoNombre(),
						s03sarlaft.getSegundoApellido(), s03sarlaft.getNumeroIdentificacion(),
						s03sarlaft.getTipoidentificacion(), s03sarlaft.getLugarExpedicion());

				segundoDatos = sarlaftRepository.actualizarSarlaft(s03sarlaft.getSexo(), s03sarlaft.getCargo(),
						s03sarlaft.getCelResidencia(), s03sarlaft.getId().getCodigo(), s03sarlaft.getCiuResidencia(),
						s03sarlaft.getDirResidencia(), s03sarlaft.getTelResidencia(), s03sarlaft.getEmail(),
						new BigDecimal(s03sarlaft.getNumerohijos().toString()), s03sarlaft.getOcupacion(),
						s03sarlaft.getId().getFecvincula(), s03sarlaft.getActPoderPublico(),
						s03sarlaft.getActEspecificacion(), new Date(), "NINGUNA", s03sarlaft.getSucur(),
						s03sarlaft.getLugarentrevista(), s03sarlaft.getFechaNacimiento());

				sarlaftReclamaciones.save(s03sarlaftReclamaciones);
				sarlaftInversiones.save(s03sarlaftInversiones);
				/**
				 * insertPropuestas(cotizaciones.getValstring(), response.getBody().getStatus(),
				 * response.getBody().getMessage());
				 */
				String mensajePersonal = "Se inserto correctamente la propuesta";
				insertPropuestas(valor, estado, "Exito", mensajePersonal);
			}
		} catch (Exception e) {
			if (segundoDatos == 0) {
				sarlaftRepository.deleteSarlaft(s03sarlaft.getId().getCodigo(), s03sarlaft.getId().getFecvincula());
			}
			String mensajePersonal = "Se produjo un error al intentar insertar en la S03Sarlaft los datos de la propuesta";
			String mensajeEstado = estado + " El error ocurrio al intentar insertar";

			insertPropuestas(valor, mensajeEstado, e.toString(), mensajePersonal);
		}

	}

	public void insertS03502(Date Fecha360) {
		S03502 s03502 = new S03502();
		S03502PK s03502PK = new S03502PK();
		s03502PK.setCodigo(s03sarlaft.getId().getCodigo());
		s03502PK.setCoddet("0000858");
		s03502.setId(s03502PK);
		s03502.setValdate(Fecha360);
		s03502.setValnumber(BigDecimal.ZERO);
		s03502.setSucrea("XXXXXX");
		s03502.setSucmod("ZZZZZZ");
		s03502.setFecrea(new Date());
		s03502Repository.save(s03502);
	}
}
