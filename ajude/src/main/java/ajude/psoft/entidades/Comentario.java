package ajude.psoft.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comentario {
	@Id
	@GeneratedValue
	private long idComentario;
	private String comentarios;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idCampanha")
	@JsonIgnore
	private Campanha campanha;
	@OneToOne(fetch = FetchType.LAZY)
	private Usuario dono;
	
	public Comentario() {
		
	}
	
	public Comentario(String comentarios) {
		this.comentarios = comentarios;
	}

	public long getIdComentario() {
		return idComentario;
	}

	public String getComentarios() {
		return comentarios;
	}

	public Campanha getCampanha() {
		return campanha;
	}

	public void setCampanha(Campanha campanha) {
		this.campanha = campanha;
	}

	public Usuario getDono() {
		return dono;
	}

	public void setDono(Usuario dono) {
		this.dono = dono;
	}
	
	
}
