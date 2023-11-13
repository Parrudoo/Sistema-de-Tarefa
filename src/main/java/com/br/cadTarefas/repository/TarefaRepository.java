package com.br.cadTarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.cadTarefas.model.Tarefa;

@Repository
public interface TarefaRepository  extends JpaRepository<Tarefa, Long> {

	

	
}
