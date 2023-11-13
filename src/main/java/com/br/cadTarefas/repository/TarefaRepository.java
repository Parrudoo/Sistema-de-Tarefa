package com.br.cadTarefas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.cadTarefas.model.Tarefa;

@Repository
public interface TarefaRepository  extends JpaRepository<Tarefa, Long> {

	List<Tarefa> findByTitulo(String titulo);

	

	

	
}
