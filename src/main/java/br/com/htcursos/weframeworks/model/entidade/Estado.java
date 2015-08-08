package br.com.htcursos.weframeworks.model.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estado {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(unique=true, nullable=false)
	private String nome;
	@Column(length=2, unique=true, nullable=false)
	private String uf;
	
	public Estado() {
	}
	
	public Estado(String nome, String uf) {
		this.nome = nome;
		this.uf = uf;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getUf() {
		return uf;
	}
}
