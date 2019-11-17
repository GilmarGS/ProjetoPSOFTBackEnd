package ajude.psoft.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	private String email;
	private String nome;
	private String ultimoNome;
	private String numCartaoDeCredito;
	private String senha;	

	public Usuario() {
		super();
	}

	public Usuario(String email, String nome, String ultimoNome, String numCartaoDeCredito, String senha) {
		super();
		this.email = email;
		this.nome = nome;
		this.ultimoNome = ultimoNome;
		this.numCartaoDeCredito = numCartaoDeCredito;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getNumCartaoDeCredito() {
		return numCartaoDeCredito;
	}

	public void setNumCartaoDeCredito(String numCartaoDeCredito) {
		this.numCartaoDeCredito = numCartaoDeCredito;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

}
