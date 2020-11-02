package br.com.imuno.request;

import java.util.List;

import br.com.imuno.model.Dose;
import lombok.Data;

@Data
public class VacinaRequest {

	private String nome;

	private String prevencao;

	private List<Dose> dose;

}
