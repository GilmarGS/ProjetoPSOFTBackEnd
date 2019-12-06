package ajude.psoft.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Doacao {
	@Id
	@GeneratedValue
	private long id;
	@OneToOne(fetch = FetchType.LAZY)
	private Usuario dono;
	private double doacoes;
	
	public Doacao() {
		
	}
	
	public Doacao(double doacoes) {
		this.doacoes = doacoes;
	}

	public long getId() {
		return id;
	}

	public double getDoacoes() {
		return doacoes;
	}

	public void setDoacoes(double doacoes) {
		this.doacoes = doacoes;
	}

	public Usuario getDono() {
		return dono;
	}

	public void setDono(Usuario dono) {
		this.dono = dono;
	}
	
	
}
