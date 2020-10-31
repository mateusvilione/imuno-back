package br.com.imuno.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "administrador")
public class Administrador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "administrador_id")
	private Long id;

	@Column(name = "cpf")
	private String cpf;

	@Column
	private String nome;

	@Column
	private String email;

	@Column
	private String senha;

	@Column(name = "usuario_id")
	private Long usuarioId;
}
