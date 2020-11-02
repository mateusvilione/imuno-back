package br.com.imuno.dto;

import br.com.imuno.model.Vacina;
import br.com.imuno.model.enums.Doses;
import lombok.Data;

@Data
public class DoseDTO {
	
	private Integer numero;

	private Integer idadeMinima;

	private Integer idadeMaxima;

	private Doses tipo;

	private Integer reforco;

	private Vacina vacina;
}
