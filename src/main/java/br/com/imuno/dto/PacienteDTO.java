package br.com.imuno.dto;

import br.com.imuno.model.Endereco;
import lombok.Data;

@Data
public class PacienteDTO {
	
	private Long id;
	private String nome;
	private String dataNascimento;
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
