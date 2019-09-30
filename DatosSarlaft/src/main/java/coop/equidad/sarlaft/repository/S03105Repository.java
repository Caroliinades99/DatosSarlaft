package coop.equidad.sarlaft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import coop.equidad.sarlaft.entidades.S03105;

public interface S03105Repository extends CrudRepository<S03105, String> {

	@Query("SELECT p FROM S03105 p WHERE p.coddet = :coddet")
	List<S03105> buscarActividad(@Param("coddet") String coddet);

	@Query("SELECT p FROM S03105 p WHERE p.coddet = :coddet")
	List<S03105> buscarCiudad(@Param("coddet") String valor);

}
