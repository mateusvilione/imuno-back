package br.com.imuno.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

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
	
	@Column
	private String email;
	
	@Column
	private String senha;
	
	@DateTimeFormat(pattern="0:yyyy-mm-dd")
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	
	@Column
	private String genero;
	
	@Column(name = "cpf_rne")
	private String cpfRne;
	
	@Column(name = "nome_mae")
	private String nomeMae;
	
	@Column(name = "nome_pai")
	private String nomePai;

	@Column
	private String telefone;
	
	@Column(name = "telefone_emergencia")
	private String telefoneEmergencia;
	

	@Column(name = "cartao_sus")
	private String cartaoSus;
	
	@Embedded
	private Endereco endereco;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "paciente_id")
	private List<Usuario> usuarioId;
}