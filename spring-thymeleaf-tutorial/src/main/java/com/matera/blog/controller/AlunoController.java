package com.matera.blog.controller;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.matera.blog.model.Aluno;
import com.matera.blog.service.AlunoService;

@RestController //Define a classe como um bean do Spring
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService service; //	Injeta a classe de serviços
	
	//Vai para tela principal do CRUD aonde são listados todos os alunos
	@GetMapping
	public @ResponseBody ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/aluno");
		mv.addObject("alunos", service.findAll());
		
		return mv;
	}
	
	//@GET
	//@Path("/listaalunos")
	//@Produces("application/json")
	// API - Listar alunos via rest
	@GetMapping(value = "/listaalunos", produces = "application/json") ///////////
	public ResponseEntity<Iterable<Aluno>> listaAlunos() {
		
		Iterable<Aluno> listaAlunos = service.findAll();
		return new ResponseEntity<Iterable<Aluno>>(listaAlunos, HttpStatus.OK);
	}
	
	//@POST
	//@Path(value = "/cadastraraluno")
	//@Consumes(value = MediaType.APPLICATION_JSON)
	// API - Inserir aluno via rest
	@PostMapping(value = "/cadastraraluno", consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<Aluno> cadastrarAluno(@RequestBody @Valid Aluno aluno) { //////////
		
		Aluno al = service.save(aluno);
		
		return new ResponseEntity<Aluno>(al, HttpStatus.CREATED);
		
	}
	

	
	//Vai para tela de adição de aluno
	@GetMapping(value = "/add")
	public ModelAndView add(Aluno aluno) {
		
		ModelAndView mv = new ModelAndView("/alunoAdd");
		mv.addObject("aluno", aluno);
		
		return mv;
	}
	
	//Vai para tela de edição de alunos (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
	@GetMapping(value = "/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		return add(service.findOne(id));
	}
	
	//Exclui um aluno por seu ID e redireciona para a tela principal
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		service.delete(id);
		
		return findAll();
	}
	
	//Recebe um objeto preenchido do Thymeleaf e valida 
	//Se tudo estiver ok, salva e volta para tela principal
	//Se houver erro, retorna para tela atual exibindo as mensagens de erro
	@PostMapping(value = "/save")
	public ModelAndView save(@Valid Aluno aluno, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(aluno);
		}
		
		service.save(aluno);
		
		return findAll();
	}
	
//	@PutMapping("/atualizar/{Id}")
//	public ResponseEntity<Aluno> updateAluno(@PathVariable("Id") String Id, @RequestBody Aluno aluno){
//		
//		Aluno al = service.findOne(Long.parseLong(Id));
//		
//		al.setNomeCompleto(aluno.getNomeCompleto());
//		al.setDataNascimento(aluno.getDataNascimento());
//		al.setEmail(aluno.getEmail());
//		al.setTelefone(aluno.getTelefone());
//		al.setCurso(aluno.getCurso());
//		al.setCidade(aluno.getCidade());
//		al.setPeriodo(aluno.getPeriodo());
//		al.setCurso(aluno.getCurso());
//		
//		service.save(al);
//		
//		return new ResponseEntity<Aluno>(al, HttpStatus.OK);
//		
//	}
	
	
	
	
	
}
