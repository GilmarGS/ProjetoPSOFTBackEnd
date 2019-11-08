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
	private long id;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idCampanha")
	@JsonIgnore
	private Campanha campanha;
	private int likes;
	
	public Like() {
		super();
	}
	
	public Like(long id, Campanha campanha, int likes) {
		this.id = id;
		this.campanha = campanha;
		this.likes = likes;
	}
}
