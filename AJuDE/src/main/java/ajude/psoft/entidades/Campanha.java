package ajude.psoft.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import ajude.psoft.enumStatus.StatusEnum;

@Entity
public class Campanha {
	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private String descricao;
	private String deadline;
	private StatusEnum status;
	private double meta;
	private double doacao;
	private String donoDaCampanha;
	private List<Comentario> comentarios;
	private int like;
	
	public Campanha() {
		super();
	}
	
	
	
	public Campanha(long id, String nome, String descricao, String deadline, StatusEnum status, double meta, double doacao, String donoDaCampanha, ArrayList<Comentario> comentarios, int like) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.deadline = deadline;
		this.status = status;
		this.meta = meta;
		this.doacao = doacao;
		this.donoDaCampanha = donoDaCampanha;
		this.comentarios = comentarios;
		this.like = like;
	}
	
}
