package br.com.htcursos.weframeworks.model.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DetalheMarca {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer anoFundacao;
	private String paisDeOrigem;
	private String fundador;
	
	@OneToOne
	private Marca montadora;
	
	public DetalheMarca() {
	}

	public DetalheMarca(Integer anoFundacao, String paisDeOrigem, String fundador, Marca montadora) {
		this.anoFundacao = anoFundacao;
		this.paisDeOrigem = paisDeOrigem;
		this.fundador = fundador;
		this.montadora = montadora;
	}

	public Integer getId() {
		return id;
	}

	public Integer getAnoFundacao() {
		return anoFundacao;
	}

	public String getPaisDeOrigem() {
		return paisDeOrigem;
	}

	public String getFundador() {
		return fundador;
	}

	public Marca getMontadora() {
		return montadora;
	}
}
