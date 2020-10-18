package br.com.imuno.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import br.com.imuno.model.Endereco;
import lombok.Data;

@Data
public class AdministradorRequest {
	@NotBlank
	private String nome;
	
	@NotBlank
	@Pattern(regexp = "(((^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$)|(^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$))|W[0-9]{7}[A-Z0-9]\r\n" + 
			"\r\n" + 
			")", message = "Fora do padrão de CPF ou RNE")
	private String cpf;
	
	@NotBlank
	@Email(message = "Email inválido")
	private String email;
	
	@NotBlank
	private String senha;
}
