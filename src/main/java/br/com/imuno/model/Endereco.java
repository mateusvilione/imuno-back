package br.com.imuno.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Endereco {
	
	@Column(name = "endereco_logradouro")
	private String logradouro;
	
	@Column(name = "endereco_numero")
	private String numero;
	
	@Column(name = "endereco_complemento")
	private String complemento;
	
	@Column(name = "endereco_bairro")
	private String bairro;
	
	@Column(name = "endereco_cidade")
	private String cidade;
	
	@Column(name = "endereco_estado")
	private String estado;
	
	@Column(name = "endereco_cep")
	private String cep;

}
