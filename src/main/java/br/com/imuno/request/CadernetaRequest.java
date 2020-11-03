package br.com.imuno.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CadernetaRequest {

	private Long loteId;

	private Long funcionarioId;

	private Long vacinaId;

	private Long doseId;

	private Long pacienteId;
	
	private LocalDate dataVacinacao;

}
