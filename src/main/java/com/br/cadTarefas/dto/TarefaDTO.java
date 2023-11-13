package com.br.cadTarefas.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarefaDTO {

	private String titulo;

	private String descricao;

	private LocalDate dataCriacao;

	private LocalDate dataConclusao;
}
