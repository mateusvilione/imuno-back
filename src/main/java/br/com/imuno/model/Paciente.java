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
@Table(name = "paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@Column(name = "data_nascimento")
	private String dataNascimento;
	
	@Column
	private String genero;
	
	@Column
	private String cpf;
	
	@Column(name = "nome_mae")
	private String nomeMae;
	
	@Column(name = "nome_pai")
	private String nomePai;
	
	@Column
	private String nacionalidade;
	
	@Column
	private String telefone;
	
	@Column(name = "telefone_ermegencia")
	private String telefoneErmegencia;
	
	@Column
	private String email;
	
	@Column
	private String senha;
	
	@Column(name = "cartao_sus")
	private String cartaoSus;
	
	@Embedded
	private Endereco endereco;

}
