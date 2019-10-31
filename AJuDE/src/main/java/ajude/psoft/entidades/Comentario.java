package ajude.psoft.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comentario {
	@Id
	@GeneratedValue
	private long id;
	private String comentario;
	private Campanha campanha;
	
	public Comentario() {
		super();
	}
	
	public Comentario(long id, String comentario, Campanha campanha) {
		this.id = id;
		this.comentario = comentario;
		this.campanha = campanha;
	}
}
