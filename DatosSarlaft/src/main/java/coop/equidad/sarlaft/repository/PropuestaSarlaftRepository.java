package coop.equidad.sarlaft.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import coop.equidad.sarlaft.entidades.Propuestassarlaft;
import coop.equidad.sarlaft.entidades.PropuestaSarlaftPK;

public interface PropuestaSarlaftRepository extends CrudRepository<Propuestassarlaft, PropuestaSarlaftPK> {

	@Query("SELECT p FROM Propuestassarlaft p WHERE p.id.codigo = :codigo and SYSDATE <= p.fecfin and p.estado != :estado")
	List<Propuestassarlaft> buscarPropuesta(@Param("codigo") String codigo, @Param("estado") String estado);

}
