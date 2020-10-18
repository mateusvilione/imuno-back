package br.com.imuno.request;


import javax.validation.constraints.NotBlank;

import br.com.imuno.model.Endereco;
import lombok.Data;

@Data
public class PostoRequest {
	
	@NotBlank
	private String nome;
	
	private Endereco endereco;
}
