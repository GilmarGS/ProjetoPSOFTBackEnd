package ajude.psoft.controladores;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ajude.psoft.entidades.Campanha;
import ajude.psoft.entidades.Comentario;
import ajude.psoft.servicos.CampanhasService;
import ajude.psoft.entidades.Doacao;
import ajude.psoft.entidades.Usuario;
import ajude.psoft.servicos.JWTService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Controller de campanhas")
@RestController
@RequestMapping("api/campanhas")
public class CampanhasController {
	private CampanhasService campanhasService;
	private JWTService jwtService;
	
	
	public CampanhasController(CampanhasService campanhasService, JWTService jwtService) {
		this.campanhasService = campanhasService;
		this.jwtService = jwtService;

	}
	@ApiOperation(value = "Cria uma campanha")
	@CrossOrigin
	@PostMapping
	@ResponseBody
	public ResponseEntity<Campanha> adicionaCampanha(@RequestBody Campanha campanha, @RequestHeader("Authorization") String header) throws ParseException, ServletException{
		campanha.setDono(pegaUsuarioToken(header));
		if(campanhasService.confereIdURL(campanha)) {
			throw new ServletException("Campanha ja cadastrada!");
		}

		if(confereData(campanha)) {
			throw new ServletException("Data de arrecadacao igual ou inferior a data atual!");
		}

		return new ResponseEntity<Campanha>(this.campanhasService.adicionaCampanha(campanha), HttpStatus.CREATED);
	}
	@ApiOperation(value = "Cria um recupera campanha a partir de substring")
	@GetMapping("{substring}")
	@ResponseBody
	public List<Campanha> recuperaCampanhas(@PathVariable("substring") String substring){
		return  campanhasService.recuperaCampanhas(substring);
	}
	@GetMapping("{idURL}")
	@ResponseBody
	public ResponseEntity<Campanha> recuperaCampanhaIdURL(@PathVariable("idURL") String idURL){
		return new ResponseEntity<Campanha>(campanhasService.recuperaCampanhaIdUrl(idURL), HttpStatus.OK);
	}
	@ApiOperation(value = "Cria um comentário")
	@CrossOrigin
	@PostMapping("comentarios/{id}")
	@ResponseBody
	public ResponseEntity<Campanha> adicionaComentario(@PathVariable long id, @RequestBody Comentario commentario, @RequestHeader(value = "Authorization") String authorizationHeader) throws Exception {
		commentario.setDono(pegaUsuarioToken(authorizationHeader));
		return new ResponseEntity<Campanha>(campanhasService.adicionaComentario(id, commentario), HttpStatus.CREATED);
	}
	@ApiOperation(value = "Apaga um comentário")
	@DeleteMapping("comentarios/{campanhaId}/{comentarioId}")
	@ResponseBody
	public ResponseEntity<Campanha> apagaComentario(@PathVariable long campanhaId, @PathVariable long comentarioId, @RequestHeader(value = "Authorization") String header) throws Exception {
		return new ResponseEntity<Campanha>(campanhasService.apagaComentario(campanhaId, comentarioId, pegaUsuarioToken(header)), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Cria e remove um like")
	@CrossOrigin
	@PutMapping("/likes/{id}")
	@ResponseBody
	public ResponseEntity<Campanha> adicionaLike(@PathVariable long id, @RequestHeader(value = "Authorization") String authorizationHeader)  throws ServletException, Exception {
		return new ResponseEntity<Campanha>(campanhasService.adicionaLike(id, pegaUsuarioToken(authorizationHeader)), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Cria uma doação")
	@CrossOrigin
	@PostMapping("/doacoes/{id}")
	@ResponseBody
	public ResponseEntity<Campanha> adicionaDoacao(@PathVariable long id, @RequestBody Doacao doacao,  @RequestHeader("Authorization") String header) throws ServletException, Exception {
		doacao.setDono(pegaUsuarioToken(header));
		double arrecadacao = doacao.getDoacoes();
		return new ResponseEntity<Campanha>(campanhasService.adicionaDoacao(id, doacao, arrecadacao), HttpStatus.CREATED);
	}

	@ApiOperation(value = "Ordena campanha pela meta")
	@CrossOrigin
	@GetMapping("/ordenaMeta")
	@ResponseBody
	public List<Campanha> ordenaCampanhaDefault(){
		return campanhasService.ordenaCampanhaMeta();			
	}

	@ApiOperation(value = "Ordena campanha pelo deadline")
	@CrossOrigin
	@GetMapping("/ordenaDeadLine")
	@ResponseBody
	public List<Campanha> ordenaCampanhaCronologia(){
		return campanhasService.ordenaCampanhaCronologia();		
	}
	
	@ApiOperation(value = "Ordena campanha pelos likes")
	@GetMapping("ordenaLikes")
	@ResponseBody
	public List<Campanha> ordenaCampanhaMenosLikes(){
		return campanhasService.ordenaCampanhaCronologia();	
		
	}
	
	private Usuario pegaUsuarioToken(String header) throws ServletException {
		return jwtService.pegaUsuarioToken(header);
	}
	
	private boolean confereData(Campanha campanha) throws ParseException {
		Date data = new Date(System.currentTimeMillis());
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data1 = (Date) formato.parse(campanha.getDeadlineArrecadacao());  

		return data1.before(data);
	}
}
