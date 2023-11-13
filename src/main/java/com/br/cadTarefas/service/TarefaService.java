package com.br.cadTarefas.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

		tarefa.setDataCriacao(LocalDate.now());
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

	public TarefaDTO consultar(Long id) {
		Optional<Tarefa> tarefa = tarefaRepository.findById(id);

		TarefaDTO dto = new TarefaDTO(tarefa.get().getTitulo(), tarefa.get().getDescricao(), tarefa.get().getDataCriacao(),
				tarefa.get().getDataConclusao());

		return dto;
	}

	public List<TarefaDTO> consultarPorTitulo(String titulo) {
		
		List<TarefaDTO> tarefaDTOs = new ArrayList<>();
		
		
		List<Tarefa> tarefas = tarefaRepository.findByTitulo(titulo);
		
		tarefas.forEach(t->{
			TarefaDTO dto = new TarefaDTO(t.getTitulo(), t.getDescricao(), t.getDataCriacao(), t.getDataConclusao());
			tarefaDTOs.add(dto);
		});
		
		return tarefaDTOs;
	}

	public void atualizar(Long id, TarefaRepository tarefaRepository) {
		
		Optional<Tarefa> tarefa = tarefaRepository.findById(id);
		
		

	}

	
}
