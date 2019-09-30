package coop.equidad.sarlaft.cache;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import coop.equidad.sarlaft.entidades.S03105;
import coop.equidad.sarlaft.repository.*;
/**
 * Esta clase permite manejar el cache de las Ciudades con codigo DANE.
 * @author adominguez
 *
 */
@Service
public class CacheCiudad {

	@Autowired
	private S03105Repository s03105Repository;

	
	/**
	 * Este método se encarga de consultar el codigo de la ciudad de la equidad correspondiente a la ciudad en falabella. 
	 * @param valor - Codigo Falabella
	 * @param codigo - Codigo del tipo de tabla Falabella
	 * @return String - Nombre ciudad
	 */
	@Cacheable("codigosCiudad")
	public List<S03105> getCodigosCiudad(String valor) {
		List<S03105> lista = s03105Repository.buscarCiudad(valor);
		return lista;
		
	}
}
