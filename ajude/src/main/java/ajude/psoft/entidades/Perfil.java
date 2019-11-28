package ajude.psoft.entidades;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Perfil {
	@Id
	@GeneratedValue
	private long id;
	@OneToOne(fetch = FetchType.LAZY)
	Usuario usuario;
	@OneToMany(fetch = FetchType.LAZY)
	Set<Doacao> doacao;
	private String urlPerfil;
	@OneToMany(fetch = FetchType.LAZY)
	Set<Campanha> campanhas;
	
	public Perfil() {
		
	}
	
	public Perfil(String urlPerfil) {

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

	public Set<Doacao> getDoacao() {
		return doacao;
	}

	public void setDoacao(Set<Doacao> doacao) {
		this.doacao = doacao;
	}

	public String getUrlPerfil() {
		return urlPerfil;
	}

	public void setUrlPerfil(String urlPerfil) {
		this.urlPerfil = urlPerfil;
	}

	public Set<Campanha> getCampanhas() {
		return campanhas;
	}

	public void setCampanhas(Set<Campanha> campanhas) {
		this.campanhas = campanhas;
	}


}
