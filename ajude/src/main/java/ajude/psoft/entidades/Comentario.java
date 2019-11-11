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
	private String Comentarios;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idCampanha")
	@JsonIgnore
	private Campanha campanha;
	
	public Comentario() {
		
	}
	
	public Comentario(String comentarios, Campanha campanha) {
		this.Comentarios = comentarios;
		this.campanha = campanha;
	}

	public long getIdComentario() {
		return idComentario;
	}

	public String getComentarios() {
		return Comentarios;
	}

	public Campanha getCampanha() {
		return campanha;
	}
	
	
}
