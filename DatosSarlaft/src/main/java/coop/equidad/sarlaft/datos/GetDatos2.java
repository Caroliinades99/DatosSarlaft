package coop.equidad.sarlaft.datos;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.IllegalFormatCodePointException;
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
public class GetDatos2 {

	int cont = 1;

//	@Scheduled(fixedDelay = 20000)
//	@Async("nombreBean")
	public void Lista2() throws ParseException {
		for (int i = 0; i < 50; i++) {
			System.out.println("Hola que mas " + cont);

			System.out.println("CONT " + cont);
			cont++;
		}

	}

}
