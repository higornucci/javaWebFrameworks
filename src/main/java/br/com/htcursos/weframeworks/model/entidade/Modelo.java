package br.com.htcursos.weframeworks.model.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Modelo {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nome;
	private String potencia;
	private boolean quatroPortas;
	
	@ManyToOne
	private Marca montadora;
	
	public Modelo() {
	}

	public Modelo(String nome, String potencia, boolean quatroPortas, Marca montadora) {
		this.nome = nome;
		this.potencia = potencia;
		this.quatroPortas = quatroPortas;
		this.montadora = montadora;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getPotencia() {
		return potencia;
	}

	public boolean isQuatroPortas() {
		return quatroPortas;
	}
	
	public Marca getMontadora() {
		return montadora;
	}
}
