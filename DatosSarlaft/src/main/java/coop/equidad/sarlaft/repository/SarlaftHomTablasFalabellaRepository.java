package coop.equidad.sarlaft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import coop.equidad.sarlaft.entidades.SarlaftHomTablasFalabella;
import coop.equidad.sarlaft.entidades.SarlaftHomTablasFalabellaPK;

public interface SarlaftHomTablasFalabellaRepository
		extends CrudRepository<SarlaftHomTablasFalabella, SarlaftHomTablasFalabellaPK> {

//	@Query("SELECT p FROM SarlaftHomTablasFalabella p WHERE p.id.codigoFalabella = :valor and p.id.tipoTable = :codigo")
	@Query("SELECT p FROM SarlaftHomTablasFalabella p")
	List<SarlaftHomTablasFalabella> tablaHomologacion();

}