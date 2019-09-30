package coop.equidad.sarlaft.repository;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import coop.equidad.sarlaft.entidades.S03sarlaft;

public interface SarlaftRepository extends JpaRepository<S03sarlaft, String> {

	@Modifying
	@Transactional(rollbackFor = Exception.class)
	@Query(value = "insert into S03sarlaft (ACT_ECONOMICA, ingresos, activos, egresos, pasivos, OTROS_INGRESOS, CONCEPTO_OTROSINGRESOS, ACT_RECURSOS_PUBLICOS, ACT_PUBLICO_GENERAL, monedaextranjera, codigo, fecvincula, TIPO_MONEDAEXTRANJERA, productosexterior, telefono, vinculos, ocupacion, NOMBRE_EMPRESA,direccion,ciudad,siniestro,tipovinculacion1,nacionalidad,estadocivil,tipopersona,PRIMER_NOMBRE, PRIMER_APELLIDO,SEGUNDO_NOMBRE, SEGUNDO_APELLIDO,NUMERO_IDENTIFICACION,tipoidentificacion,LUGAR_EXPEDICION) VALUES (?,?,?,?,?,?,?,?,?,?,?,trunc(?),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", nativeQuery = true)
	int insertSarlaft(String ACT_ECONOMICA, BigDecimal ingresos, BigDecimal activos, BigDecimal egresos,
			BigDecimal pasivos, BigDecimal OTROS_INGRESOS, String CONCEPTO_OTROSINGRESOS,
			BigDecimal ACT_RECURSOS_PUBLICOS, BigDecimal ACT_PUBLICO_GENERAL, BigDecimal monedaextranjera,
			String codigo, Date fecvincula, BigDecimal TIPO_MONEDAEXTRANJERA, BigDecimal productosexterior,
			String telefono, BigDecimal vinculos, String ocupacion, String NOMBRE_EMPRESA, String direccion,
			String ciudad, String siniestro, BigDecimal tipovinculacion1, String nacionalidad, BigDecimal estadocivil,
			BigDecimal tipopersona, String PRIMER_NOMBRE, String PRIMER_APELLIDO, String SEGUNDO_NOMBRE,
			String SEGUNDO_APELLIDO, String NUMERO_IDENTIFICACION, BigDecimal tipoidentificacion,
			String LUGAR_EXPEDICION);

	@Modifying
	@Transactional(rollbackFor = Exception.class)
	@Query(value = "UPDATE S03sarlaft set sexo =:sexo, cargo = :cargo, CEL_RESIDENCIA =:celResidencia, CIU_RESIDENCIA = :CIU_RESIDENCIA, DIR_RESIDENCIA = :dirResidencia, TEL_RESIDENCIA = :telResidencia, email = :email, numerohijos = :hijos, PROVIENEN_RECURSOS = :provienenRecursos, ACT_PODER_PUBLICO = :poderPublico, tipovinculacion2 = 0,tipovinculacion3 = 0,tipovinculacion4 = 0, ACT_ESPECIFICACION = :afirmativa, TIPODOCUMENTO_RL = 0, TIPO_EMPRESA = 0, TIPO_SOCIEDAD = 0, ACT_ECONOMICA_PJ =0, INGRESOS_PJ = 0, EGRESOS_PJ = 0, OTROSINGRESOS_PJ = 0, ACTIVOS_PJ = 0, PASIVOS_PJ = 0, clasevinculacion = 1, pep = 2, fechaentrevista = :fechaentrevista, resultado = 1,observaciones = :observaciones, tipoactividad = 1,sucur= :sucur, lugarentrevista = :lugarentrevista, FECHA_NACIMIENTO = :fechaNacimiento where codigo= :codigo and fecvincula = trunc(:fecvincula)", nativeQuery = true)
	int actualizarSarlaft(@Param("sexo") int sexo, @Param("cargo") String cargo,
			@Param("celResidencia") String celResidencia, @Param("codigo") String codigo,
			@Param("CIU_RESIDENCIA") String CIU_RESIDENCIA, @Param("dirResidencia") String dirResidencia,
			@Param("telResidencia") String telResidencia, @Param("email") String email,
			@Param("hijos") BigDecimal hijos, @Param("provienenRecursos") String provienenRecursos,
			@Param("fecvincula") Date fecvincula, @Param("poderPublico") BigDecimal poderPublico,
			@Param("afirmativa") String afirmativa, @Param("fechaentrevista") Date fechaentrevista,
			@Param("observaciones") String sucur, @Param("sucur") String observaciones,
			@Param("lugarentrevista") String lugarentrevista, @Param("fechaNacimiento") Date fechaNacimiento);

	@Modifying
	@Transactional()
	@Query(value = "delete from S03SARLAFT where codigo= :codigo and fecvincula = trunc(:fecvincula)", nativeQuery = true)
	int deleteSarlaft(String codigo, Date fecvincula);
}
