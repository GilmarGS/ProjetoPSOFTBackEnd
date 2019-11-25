package ajude.psoft.entidades;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ajude.psoft.enums.EnumStatus;

@Entity
public class Campanha {
	@Id
	@GeneratedValue
	private long idCampanha;
	private String nomeCurto;
	private String idURL;
	private String descricao;
	private String deadlineArrecadacao;
	private EnumStatus status;
	private double meta;
	@OneToMany(fetch = FetchType.LAZY)
	private Set<Doacao> doacoes;
	@OneToOne(fetch = FetchType.EAGER)
	private Usuario dono; 	
	@OneToMany(fetch = FetchType.LAZY)
	private Set<Comentario> comentarios;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Usuario> likes;
	
	public Campanha() {
		
	}
	
	public Campanha(String nomeCurto, String idURL, String descricao, String deadlineArrecadacao, double meta, Usuario dono) {
		this.nomeCurto = nomeCurto;
		this.idURL = idURL;
		this.descricao = descricao;
		this.deadlineArrecadacao = deadlineArrecadacao;
		this.status = EnumStatus.ATIVA;
		this.meta = meta;
		this.doacoes = new HashSet<Doacao>();
		this.dono = dono;
		this.comentarios = new HashSet<Comentario>();
		this.likes = new ArrayList<>();

	}
	
	public long getIdCampanha() {
		return idCampanha;
	}

	public void setIdCampanha(long idCampanha) {
		this.idCampanha = idCampanha;
	}

	public String getNomeCurto() {
		return nomeCurto;
	}

	public void setNomeCurto(String nomeCurto) {
		this.nomeCurto = nomeCurto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDeadlineArrecadacao() {
		return deadlineArrecadacao;
	}

	public void setDeadlineArrecadacao(String deadlineArrecadacao) {
		this.deadlineArrecadacao = deadlineArrecadacao;
	}

	public EnumStatus getStatus() {
		return status;
	}

	public void setStatus(EnumStatus status) {
		this.status = status;
	}

	public double getMeta() {
		return meta;
	}

	public void setMeta(double meta) {
		this.meta = meta;
	}

	public Set<Doacao> getDoacoes() {
		return doacoes;
	}

	public void setDoacoes(Set<Doacao> doacoes) {
		this.doacoes = doacoes;
	}
	
	public Set<Comentario> getComentarios() {
		return comentarios;
	}
	
	public void setComentarios(Comentario comentario){
		this.comentarios.add(comentario);
	}

	public Usuario getDono() {
		return dono;
	}

	public void setDono(Usuario dono) {
		this.dono = dono;
	}

	public List<Usuario> getLikes() {
		return likes;
	}

	public void setLikes(Usuario likes) {
		this.likes.add(likes);
	}

	public String getIdURL() {
		return this.idURL;
	}

}
	