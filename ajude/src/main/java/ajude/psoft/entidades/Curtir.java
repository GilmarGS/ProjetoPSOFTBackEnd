package ajude.psoft.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToOne;


@Entity
public class Curtir {
	@Id
	@GeneratedValue
	private long id;
	@OneToOne(fetch = FetchType.LAZY)
	private Usuario usuario;
	
	public Curtir() {
		
	}

	public Curtir(Usuario usuario) {

		this.usuario = usuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
