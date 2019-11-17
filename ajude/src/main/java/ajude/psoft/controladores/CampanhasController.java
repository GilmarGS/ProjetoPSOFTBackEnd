package ajude.psoft.controladores;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<Campanha> adicionaCampanha(@RequestBody Campanha campanha) throws ParseException, ServletException{


		if(confereData(campanha)) {
			throw new ServletException("Data de arrecadacao igual ou inferior a data atual!");
		}
		return new ResponseEntity<Campanha>(this.campanhasService.adicionaCampanha(campanha), HttpStatus.CREATED);
	}
	
	private boolean confereData(Campanha campanha) throws ParseException {
		Date data = new Date(System.currentTimeMillis());
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data1 = (Date) formato.parse(campanha.getDeadlineArrecadacao());  // Data no formato "yyyyMMdd";
		
		return data1.before(data);
	}
	
	@GetMapping("api/campanhas/{substring}")
	public List<Campanha> recuperaCampanhas(@PathVariable("substring") String substring){
		return  campanhasService.recuperaCampanhas(substring);
	}
}
