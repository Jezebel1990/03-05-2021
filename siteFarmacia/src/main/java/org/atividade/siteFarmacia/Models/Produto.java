package org.atividade.siteFarmacia.Models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "produto")

public class Produto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  long id;
	
	@NotNull
	@Size(min =5, max=100)
	private String categoria;
	
	
	@NotNull
	@Size(min =10, max=500)
	private String descricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date validade =new java.sql.Date(System.currentTimeMillis());
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
}

