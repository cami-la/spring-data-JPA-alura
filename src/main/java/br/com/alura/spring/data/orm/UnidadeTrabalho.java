package br.com.alura.spring.data.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="unidade_trabalho")
public class UnidadeTrabalho {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String descricao;
	private String endereco;
	
	@ManyToMany
	private Funcionario funcionario;

	public UnidadeTrabalho() {
	}

	public UnidadeTrabalho(String descricao, String endereco, Funcionario funcionario) {
		this.descricao = descricao;
		this.endereco = endereco;
		this.funcionario = funcionario;
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getEndereco() {
		return endereco;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	@Override
	public String toString() {
		return "UnidadeTrabalho [id=" + id + ", descricao=" + descricao + ", endereco=" + endereco + ", funcionario="
				+ funcionario + "]";
	}
	
}
