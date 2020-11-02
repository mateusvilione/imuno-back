package br.com.imuno.dto;

import java.util.List;

import br.com.imuno.model.Dose;
import lombok.Data;

@Data
public class VacinaDTO {

	private Long id;

	private String nome;

	private String prevencao;

	private List<Dose> dose;

}
