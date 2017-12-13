package com.matera.blog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.matera.blog.model.Produto;
import com.matera.blog.service.ProdutoService;

@Controller //Define a classe como um bean do Spring
public class ProdutoController {
	
	@Autowired
	private ProdutoService service; //	Injeta a classe de serviços
	
	//Vai para tela principal do CRUD aonde são listados todos os produtos
	@GetMapping("/produto")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/produto");
		mv.addObject("produtos", service.findAll());
		
		return mv;
	}
	
	//Vai para tela de adição de produto
	@GetMapping("/produto/add")
	public ModelAndView add(Produto produto) {
		
		ModelAndView mv = new ModelAndView("/produtoAdd");
		mv.addObject("produto", produto);
		
		return mv;
	}
	
	//Vai para tela de edição de produtos (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
	@GetMapping("/produto/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		return add(service.findOne(id));
	}
	
	//Exclui um produto por seu ID e redireciona para a tela principal
	@GetMapping("/produto/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		service.delete(id);
		
		return findAll();
	}
	
	//Recebe um objeto preenchido do Thymeleaf e valida 
	//Se tudo estiver ok, salva e volta para tela principal
	//Se houver erro, retorna para tela atual exibindo as mensagens de erro
	@PostMapping("/produto/save")
	public ModelAndView save(@Valid Produto produto, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(produto);
		}
		
		service.save(produto);
		
		return findAll();
	}
	
}
