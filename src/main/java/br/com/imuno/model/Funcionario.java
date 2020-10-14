package br.com.imuno.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String cpf;
	
	@Column
	private String coren;
	
	@Embedded
	private Endereco endereco;
	
	@Column
	private String email;
	
	@Column
	private String telefone;
	
	@Column(name = "telefone_emergencia")
	private String telefoneEmergencia;
	
	@Column
	private String senha;

}
