package com.matera.blog.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity(name = "tbl_produto") //Define o nome da tabela que será criada no banco de dados
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@Column(nullable = false, length = 150) //Define propriedades da coluna
	@NotBlank(message = "Nome é uma informação obrigatória.") //Define qual mensagem será exibida caso a validação da coluna falhar
	private String nome;
	
	@Column(nullable = false, length = 150)
	@NotBlank(message = "Descricao é uma informação obrigatória.")
	private String descricao;
	
	@Column(nullable = false, length = 150)
	@NotBlank(message = "Descricao é uma informação obrigatória.")
	private String fornecedor;
	
	@Column(nullable = false, length = 150)
	@NotBlank(message = "Descricao é uma informação obrigatória.")
	private String estadoOrigem;
	
	@Column(nullable = false)
	@NotNull(message = "Quantidade é uma informação obrigatória.")
	//@Range(min=0, max=1000000)
	private Integer quantidade;
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getEstadoOrigem() {
		return estadoOrigem;
	}

	public void setEstadoOrigem(String estadoOrigem) {
		this.estadoOrigem = estadoOrigem;
	}


	
	
}