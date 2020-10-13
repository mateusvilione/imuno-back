package br.com.imuno.exception;

@SuppressWarnings("serial")
public class PacienteNaoEncontradoException extends EntidadeNaoEncontradaException {

	public PacienteNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public PacienteNaoEncontradoException(Long id) {
		this(String.format("Não existe um cadastro de paciente com o código %d", id));
	}
	
}
