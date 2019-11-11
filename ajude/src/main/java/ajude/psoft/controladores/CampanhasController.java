package ajude.psoft.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import ajude.psoft.entidades.Campanha;
import ajude.psoft.servicos.CampanhasService;

@RestController
public class CampanhasController {
	private CampanhasService campanhasService;
	
	public CampanhasController(CampanhasService campanhasService) {
		this.campanhasService = campanhasService;
	}
	
	@PostMapping("api/campanhas")
	public ResponseEntity<Campanha> adicionaCampanha(@RequestBody Campanha campanha,  @RequestHeader("Authorization") String header){
		return new ResponseEntity<Campanha>(this.campanhasService.adicionaCampanha(campanha), HttpStatus.CREATED);
	}
}
