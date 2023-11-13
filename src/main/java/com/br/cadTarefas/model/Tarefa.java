package com.br.cadTarefas.model;

import java.time.LocalDate;

import com.br.cadTarefas.dto.TarefaDTO;
import com.br.cadTarefas.enums.Status;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tarefa {
	
	

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titulo;
	
	private String descricao;
	
	private LocalDate dataCriacao;
	
	private LocalDate dataConclusao;
	
	private Status status;
}
