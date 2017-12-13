package com.matera.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matera.blog.model.Produto;
import com.matera.blog.repository.ProdutoRepository;

@Service //Define a classe como um bean do Spring
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository; //Injeta o repositório
	
	//Retorna uma lista com todos produtos inseridos
	public List<Produto> findAll() {
		return repository.findAll(); 
	}
	
	//Retorno um produto a partir do ID
	public Produto findOne(Long id) {
		return repository.findOne(id);
	}
	
	//Salva ou atualiza um produto
	public Produto save(Produto produto) {
		return repository.saveAndFlush(produto);
	}
	
	//Exclui um produto
	public void delete(Long id) {
		repository.delete(id);
	}

}