package br.com.imuno.request;

import br.com.imuno.model.Endereco;
import lombok.Data;

@Data
public class FuncionarioRequest {
	
	private Long id;
	private String nome;
	private String cpf;
	private String coren;
	private Endereco endereco;
	private String email;
	private String telefone;
	private String senha;

}
