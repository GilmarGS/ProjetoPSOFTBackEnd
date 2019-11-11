package ajude.psoft.entidades;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ajude.psoft.enums.EnumStatus;

@Entity
public class Campanha {
	@Id
	@GeneratedValue
	private long idCampanha;
	private String nomeCurto;
	private String descricao;
	private String deadlineArrecadacao;
	private EnumStatus status;
	private double meta;
	private double doacoes;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="email")
	@JsonIgnore
	private Usuario dono; 	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="idComentario")
	@JsonIgnore
	private Set<Comentario> comentarios;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="email")
	private List<Usuario> likes;
	
	public Campanha() {
		
	}
	
	public Campanha(String nomeCurto, String descricao, String deadlineArrecadacao, EnumStatus status, double meta, double doacoes, Usuario dono, Set<Comentario> comentarios, List<Usuario> likes) {
		this.nomeCurto = nomeCurto;
		this.descricao = descricao;
		this.deadlineArrecadacao = deadlineArrecadacao;
		this.status = EnumStatus.ATIVA;
		this.meta = meta;
		this.doacoes = doacoes;
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

	public double getDoacoes() {
		return doacoes;
	}

	public void setDoacoes(double doacoes) {
		this.doacoes = doacoes;
	}

	public Usuario getDono() {
		return dono;
	}

	
	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	/*public List<Like> getLikes() {
		return this.likes;
	}*/
}
	