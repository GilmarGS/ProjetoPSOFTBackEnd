package ajude.psoft.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ajude.psoft.servicos.PerfisService;
import ajude.psoft.entidades.Perfil;

@RestController
public class PerfisController {
	private PerfisService perfisService;

	
	public PerfisController(PerfisService perfisService) {
		this.perfisService = perfisService;

	}
	
	@CrossOrigin
	@ResponseBody
	@GetMapping("/perfis/{url}")
	public ResponseEntity<Perfil> recuperaPerfil(@PathVariable("url") String url){
		return new ResponseEntity<Perfil>(perfisService.recuperaPerfil(url), HttpStatus.OK);
	}

}
