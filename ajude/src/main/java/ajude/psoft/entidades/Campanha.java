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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ajude.psoft.enums.EnumStatus;

@Entity
public class Campanha {
	@Id
	@GeneratedValue
	private long idCampanha;
	private String nomeCurto;
	//identificador de URL único da campanha (gerado pelo frontend a partir do nome curto)
	private String descricao;
	private String deadlineArrecadacao;
	private EnumStatus status;
	private double meta;
	private double doacoes;
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "email")
	@JsonIgnore
	private Usuario dono; 
	@OneToMany(mappedBy = "campanha", fetch = FetchType.EAGER)
	private List<Comentario> comentarios;
	@OneToMany(mappedBy = "campanha", fetch = FetchType.EAGER)
	private Set<Like> likes;
	
	public Campanha() {
		super();
	}
	public Campanha(long idCampanha, String nomeCurto, String descricao, String deadlineArrecadacao, double meta, double doacoes, Usuario dono, List<Comentario> comentarios, Set<Like> likes) {
		this.idCampanha = idCampanha;
		this.nomeCurto = nomeCurto;
		this.descricao = descricao;
		this.deadlineArrecadacao = deadlineArrecadacao;
		this.status = EnumStatus.ATIVA;
		this.meta = meta;
		this.doacoes = doacoes;
		this.comentarios = new ArrayList<Comentario>();
		this.likes = new HashSet<Like>();
	}
}
