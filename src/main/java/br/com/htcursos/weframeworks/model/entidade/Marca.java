package br.com.htcursos.weframeworks.model.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Marca {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nome;
	
	@OneToMany(mappedBy="montadora")
	private List<Modelo> modelos = new ArrayList<>();
	
	public Marca() {
	}
	
	public Marca(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
