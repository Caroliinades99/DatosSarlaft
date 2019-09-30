package coop.equidad.sarlaft.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.equidad.sarlaft.entidades.S03sarlaft;
import coop.equidad.sarlaft.repository.SarlaftRepository;

@RestController
public class Api {

	@Autowired
	SarlaftRepository sarlaftRepository;
	
	@PostMapping("/saveSarlaft")
	S03sarlaft save() {
		S03sarlaft s03sarlaftResp = new S03sarlaft();
		S03sarlaft s03sarlaft = new S03sarlaft();
		s03sarlaft.setIdentificacionRl("0");
		s03sarlaftResp = sarlaftRepository.save(s03sarlaft);
		return s03sarlaftResp;
	}


}
