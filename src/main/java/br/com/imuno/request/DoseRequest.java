package br.com.imuno.request;

import br.com.imuno.model.enums.Doses;
import lombok.Data;

@Data
public class DoseRequest {
	
	private Integer numero;

	private Integer idadeMinima;

	private Integer idadeMaxima;

	private Doses tipo;

	private Integer reforco;
	
	private Long vacinaId;
	
}
