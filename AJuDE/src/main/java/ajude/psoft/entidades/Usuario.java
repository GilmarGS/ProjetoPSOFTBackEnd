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
		this.email = email;
		this.nome = nome;
		this.ultimoNome = ultimoNome;
		this.numCartaoDeCredito = numCartaoDeCredito;
		this.senha = senha;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUltimoNome() {
		return this.ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getNumCartaoDeCredito() {
		return this.numCartaoDeCredito;
	}

	public void setNumCartaoDeCredito(String numCartaoDeCredito) {
		this.numCartaoDeCredito = numCartaoDeCredito;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenhaCartaoDeCredito(String senhaCartaoDeCredito) {
		this.senha = senhaCartaoDeCredito;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numCartaoDeCredito == null) ? 0 : numCartaoDeCredito.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((ultimoNome == null) ? 0 : ultimoNome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numCartaoDeCredito == null) {
			if (other.numCartaoDeCredito != null)
				return false;
		} else if (!numCartaoDeCredito.equals(other.numCartaoDeCredito))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (ultimoNome == null) {
			if (other.ultimoNome != null)
				return false;
		} else if (!ultimoNome.equals(other.ultimoNome))
			return false;
		return true;
	}
	
	
}
