package br.com.imuno.dto;

import java.time.LocalDate;

import br.com.imuno.model.Administrador;
import br.com.imuno.model.Posto;
import br.com.imuno.model.Vacina;
import lombok.Data;

@Data
public class LoteDTO {

	private Long id;
	
	private String codigo;

	private LocalDate dataFabricacao;

	private Integer quantidade;

	private LocalDate dataEntrada;

	private LocalDate dataValidade;

	private Administrador administrador;

	private Posto posto;

	private Vacina vacina;

}
