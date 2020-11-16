package br.com.imuno.dto;

import br.com.imuno.model.Administrador;
import br.com.imuno.model.Endereco;
import lombok.Data;

@Data
public class PostoDTO {
	private Long id;
	
	private String nome;
	
	private String cnes;

	private String telefone;
	
	private Endereco endereco;
	
	private Administrador administrador;
}
