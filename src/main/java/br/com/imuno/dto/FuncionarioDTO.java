package br.com.imuno.dto;

import br.com.imuno.model.Endereco;
import lombok.Data;

@Data
public class FuncionarioDTO {
	
	private Long Id;
	private String nome;
	private String cpf;
	private String coren;
	private Endereco endereco;
	private String email;
	private String telefone;
	private String telefoneEmergencia;
	private String senha;

}
