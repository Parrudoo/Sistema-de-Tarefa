package com.br.cadTarefas.dto;

import java.time.LocalDate;
import java.util.Optional;

import com.br.cadTarefas.model.Tarefa;
import com.br.cadTarefas.repository.TarefaRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarefaDTO {
	
	public TarefaDTO(Tarefa tarefa) {
		this.titulo = tarefa.getTitulo();
		this.descricao = tarefa.getDescricao();
	}
	

	private String titulo;

	private String descricao;

	private LocalDate dataCriacao;

	private LocalDate dataConclusao;

	public Tarefa atualizar(Long id, TarefaRepository tarefaRepository) {
		
		Tarefa tarefa = tarefaRepository.getOne(id);
		
		tarefa.setTitulo(this.titulo);
		tarefa.setDescricao(this.descricao);		
		
		
		return tarefa;
	}
}
