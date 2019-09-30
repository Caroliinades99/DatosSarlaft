package coop.equidad.sarlaft.cache;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import coop.equidad.sarlaft.entidades.S03105;
import coop.equidad.sarlaft.repository.*;

/**
 * Esta clase permite manejar el cache de las Actividades Economicas.
 * @author adominguez
 *
 */
@Service
public class CacheActividadEconomica {

	@Autowired
	private S03105Repository s03105Repository;
	
	/**
	 * Este método se encarga de consultar el codigo de la actividad economica de la equidad correspondiente a la actividad en falabella. 
	 * @param valor - Codigo Actividad Falabella
	 * @return String - Nombre Actividad Equidad
	 */
	@Cacheable("codigosActividad")
	public List<S03105> getCodigosActividad(String valor) {
		List<S03105> lista = s03105Repository.buscarActividad(valor);
		return lista;
	}
}
