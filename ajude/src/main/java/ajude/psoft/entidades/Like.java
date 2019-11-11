package ajude.psoft.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Like {
	@Id
	@GeneratedValue
	private long idLike;
	private int likes;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idCampanha")
	@JsonIgnore
	private Campanha campanha;
	
	public Like() {
		
	}
	public Like(int likes, Campanha campanha) {
		this.likes = likes;
		this.campanha = campanha;
	}
	public long getIdLike() {
		return idLike;
	}
	public int getLikes() {
		return likes;
	}
	public Campanha getCampanha() {
		return campanha;
	}
}
