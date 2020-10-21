package br.com.imuno.dto;

import lombok.Data;

@Data
public class AdministradorDTO {
	
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String email;
	
	private String senha;
	
}
