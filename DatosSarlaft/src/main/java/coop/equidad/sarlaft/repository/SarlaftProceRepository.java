package coop.equidad.sarlaft.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import coop.equidad.sarlaft.entidades.S03sarlaft;

@Repository
public interface SarlaftProceRepository extends CrudRepository<S03sarlaft, String> {

	@Transactional
	@Procedure(name = "basicos_falabella")
	String datosPerson(@Param("p_produ") String pProdu);

}
