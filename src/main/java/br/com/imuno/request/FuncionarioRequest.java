package br.com.imuno.request;

import javax.validation.constraints.Email;

import br.com.imuno.model.Endereco;
import lombok.Data;

@Data
public class FuncionarioRequest {
	
	private Long id;
	private String nome;
	private String cpf;
	private String coren;
	private Endereco endereco;
	@Email(message = "Email inválido")
	private String email;
	private String telefone;
	private String senha;

}
