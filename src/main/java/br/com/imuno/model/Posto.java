package br.com.imuno.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Posto")
public class Posto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String cnes;
	
	@Column
	private String telefone;
	
	@Embedded
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name = "administrador_id", nullable = false)
	private Administrador administrador;
}
