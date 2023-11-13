package com.br.cadTarefas.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.cadTarefas.dto.TarefaDTO;
import com.br.cadTarefas.enums.Status;
import com.br.cadTarefas.model.Tarefa;
import com.br.cadTarefas.repository.TarefaRepository;

@Service
public class TarefaService {
	
	@Autowired
	private TarefaRepository tarefaRepository;

	
	public Tarefa salvarTarefa(TarefaDTO dto) {
		
		Tarefa tarefa = converter(dto);
		
		tarefa.setDataConclusao(LocalDate.now());
		tarefa.setStatus(Status.ABERTA);
		
		return tarefaRepository.save(tarefa);
		
	}


	private Tarefa converter(TarefaDTO dto) {
	
		Tarefa tarefa = new Tarefa();
		
		tarefa.setTitulo(dto.getTitulo());
		tarefa.setDataConclusao(dto.getDataConclusao());
		tarefa.setDataCriacao(dto.getDataCriacao());
		tarefa.setDescricao(dto.getDescricao());	
		
		
		return tarefa;
	}
}
