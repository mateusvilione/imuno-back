package br.com.imuno.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import br.com.imuno.model.Endereco;
import lombok.Data;

@Data
public class PacienteDTO {
	
	private Long id;
	@Column(table = "usuario", name = "nome")
	private String nome;
	private LocalDate dataNascimento;
	private String genero;
	private String cpfRne;
	private String nomeMae;
	private String nomePai;
	private String telefone;
	private String telefoneEmergencia;
	private String email;
	private String cartaoSus;
	private Endereco endereco;
	
}
