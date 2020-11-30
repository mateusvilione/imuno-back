package br.com.imuno.request;

import java.time.LocalDate;

import br.com.imuno.model.enums.Doses;
import lombok.Data;

@Data
public class CadernetaRequest {

	private Long loteId;

	private Long funcionarioId;

	private Long vacinaId;

	private Doses dose;

	private Long pacienteId;
	
	private LocalDate dataVacinacao;
	
	private Long PostoId;

}
