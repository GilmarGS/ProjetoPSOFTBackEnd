package ajude.psoft.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comentario {
	@Id
	@GeneratedValue
	private long idComentario;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idCampanha")
	@JsonIgnore
	private Campanha campanha;
	private String comentarios;
	
	public Comentario() {
		super();
	}
	
	public Comentario(long idComentario, String comentarios, Campanha campanha) {
		this.idComentario = idComentario;
		this.comentarios = comentarios;
		this.campanha = campanha;
	}
}
