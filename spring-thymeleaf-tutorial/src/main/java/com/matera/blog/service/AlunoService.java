package com.matera.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matera.blog.model.Aluno;
import com.matera.blog.repository.AlunoRepository;

@Service //Define a classe como um bean do Spring
public class AlunoService {
	
	@Autowired
	private AlunoRepository repository; //Injeta o repositório
	
	//Retorna uma lista com todos produtos inseridos
	public List<Aluno> findAll() {
		return repository.findAll(); 
	}
	
	//Retorno um produto a partir do ID
	public Aluno findOne(Long id) {
		return repository.findOne(id);
	}
	
	//Salva ou atualiza um produto
	public Aluno save(Aluno aluno) {
		return repository.saveAndFlush(aluno);
	}
	
	//Exclui um produto
	public void delete(Long id) {
		repository.delete(id);
	}

}