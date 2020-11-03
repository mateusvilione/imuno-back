package br.com.imuno.dto;

import java.time.LocalDate;

import br.com.imuno.model.Dose;
import br.com.imuno.model.Funcionario;
import br.com.imuno.model.Lote;
import br.com.imuno.model.Paciente;
import br.com.imuno.model.Vacina;
import lombok.Data;

@Data
public class CadernetaDTO {
	private Lote lote;

	private Funcionario funcionario;

	private Vacina vacina;

	private Dose dose;

	private Paciente paciente;
	
	private LocalDate dataVacinacao;
}
