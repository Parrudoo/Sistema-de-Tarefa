package com.br.cadTarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.cadTarefas.dto.TarefaDTO;
import com.br.cadTarefas.model.Tarefa;
import com.br.cadTarefas.repository.TarefaRepository;
import com.br.cadTarefas.service.TarefaService;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/tarefa")
public class CadastrarTarefaController {
	
	@Autowired
	private TarefaService tarefaService;
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@PostMapping("/cad")
	@Transactional
	public ResponseEntity<Tarefa> cadastrarTarefa(@RequestBody TarefaDTO tarefaDTO) {
		
		Tarefa tarefa = tarefaService.salvarTarefa(tarefaDTO);		
		
		return  ResponseEntity.ok(tarefa);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TarefaDTO> consultar(@PathVariable("id") Long id){
		
		TarefaDTO tarefaDTO =  tarefaService.consultar(id);
		
		return ResponseEntity.ok(tarefaDTO);
	}
	
	@GetMapping("/consuTitulo/{titulo}")
	public ResponseEntity<List<TarefaDTO>> consultarPorTitulo(@PathVariable("titulo") String titulo){
		
		List<TarefaDTO> tarefaDTO = tarefaService.consultarPorTitulo(titulo);
		
		return ResponseEntity.ok(tarefaDTO);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TarefaDTO> atualizar(@PathVariable("id") Long id, @RequestBody TarefaDTO tarefaDTO){
		
		
	Tarefa tarefa = tarefaDTO.atualizar(id,tarefaRepository);
		
		return ResponseEntity.ok(new TarefaDTO(tarefa));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> removerTarefa(@PathVariable("id") Long id){
		tarefaRepository.deleteById(id);		
		return ResponseEntity.ok().build();
	}
	
	
}
