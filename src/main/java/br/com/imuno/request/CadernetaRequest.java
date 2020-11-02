package br.com.imuno.request;

import br.com.imuno.model.Dose;
import br.com.imuno.model.Funcionario;
import br.com.imuno.model.Lote;
import br.com.imuno.model.Paciente;
import br.com.imuno.model.Vacina;
import lombok.Data;

@Data
public class CadernetaRequest {

	private Lote lote;

	private Funcionario funcionario;

	private Vacina vacina;

	private Dose dose;

	private Paciente paciente;

}