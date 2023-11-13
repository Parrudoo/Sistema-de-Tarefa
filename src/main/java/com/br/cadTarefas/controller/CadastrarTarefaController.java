package com.br.cadTarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.cadTarefas.dto.TarefaDTO;
import com.br.cadTarefas.model.Tarefa;
import com.br.cadTarefas.service.TarefaService;


@RestController
@RequestMapping("/tarefa")
public class CadastrarTarefaController {
	
	@Autowired
	private TarefaService tarefaService;
	
	@PostMapping("/cad")
	public ResponseEntity<Tarefa> cadastrarTarefa(@RequestBody TarefaDTO tarefaDTO) {
		
		Tarefa tarefa = tarefaService.salvarTarefa(tarefaDTO);
		
		
		return  ResponseEntity.ok(tarefa);
	}
}
