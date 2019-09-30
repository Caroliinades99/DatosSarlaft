package coop.equidad.sarlaft.cache;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import coop.equidad.sarlaft.repository.*;
import coop.equidad.sarlaft.entidades.*;

/**
 * Esta clase permite manejar el cache de los codigos de falabella y la Equidad.
 * 
 * @author adominguez
 *
 */
@Service
public class CacheCodigosEquidad {

	@Autowired
	private SarlaftHomTablasFalabellaRepository sarlaftHomTablasFalabella;

	/**
	 * Este método se encarga de consultar el codigo de las tablas de homologacion
	 * de Falabella y Equidad.
	 * 
	 * @param valor  - Codigo Falabella
	 * @param codigo - Codigo del tipo de tabla Falabell
	 * @return String - Codigo Actividad Equidad
	 */
	@Cacheable("codigosCodigosEquidad")
	public List<SarlaftHomTablasFalabella> getCodigosEquidad() {
		List<SarlaftHomTablasFalabella> lista = sarlaftHomTablasFalabella.tablaHomologacion();
		return lista;

	}
}
