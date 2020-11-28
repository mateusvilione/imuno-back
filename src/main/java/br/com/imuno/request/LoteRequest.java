package br.com.imuno.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class LoteRequest {

	private Long id;
	
	private String codigo;

	private LocalDate dataFabricacao;

	private Integer quantidade;

	private LocalDate dataEntrada;

	private LocalDate dataValidade;

	private Long administradorId;

	private Long postoId;

	private Long vacinaId;

}
