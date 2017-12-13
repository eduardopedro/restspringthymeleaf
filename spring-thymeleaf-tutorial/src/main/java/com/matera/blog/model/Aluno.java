	package com.matera.blog.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "tbl_aluno") //Define o nome da tabela que será criada no banco de dados
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@Column(nullable = false, length = 150) //Define propriedades da coluna
	@NotBlank(message = "Nome é uma informação obrigatória.") //Define qual mensagem será exibida caso a validação da coluna falhar
	private String nomeCompleto;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Data é uma informação obrigatória.")
	private Date dataNascimento;
	
	@Column(nullable = false, length = 150) //Define propriedades da coluna
	@NotBlank(message = "Nome é uma informação obrigatória.") //Define qual mensagem será exibida caso a validação da coluna falhar
	@Email
	private String email;
	
	@Column(nullable = false, length = 150)
	@NotBlank(message = "Descricao é uma informação obrigatória.")
	private String telefone;
	
	@Column(nullable = false, length = 150)
	@NotBlank(message = "Descricao é uma informação obrigatória.")
	private String curso;
	
	@Column(nullable = false, length = 150)
	@NotBlank(message = "Descricao é uma informação obrigatória.")
	private String cidade;
	
	@Column(nullable = false)
	@NotNull(message = "Quantidade é uma informação obrigatória.")
	@Range(min=1, max=5)
	private Integer periodo;
	
	@Column(nullable = false)
	@NotNull(message = "Quantidade é uma informação obrigatória.")
	@CPF
	private String cpf;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	



	
	
}