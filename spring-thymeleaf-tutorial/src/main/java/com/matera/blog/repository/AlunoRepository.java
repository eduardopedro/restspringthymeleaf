package com.matera.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matera.blog.model.Aluno;

@Repository //Define a classe como um bean do Spring
public interface AlunoRepository extends JpaRepository<Aluno, Long> { } 
//Deve estender JpaRepository e declarar a entidade (Post) e o tipo de chave primária (Long)