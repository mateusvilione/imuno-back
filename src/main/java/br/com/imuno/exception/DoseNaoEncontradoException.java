package br.com.imuno.exception;

@SuppressWarnings("serial")
public class DoseNaoEncontradoException extends EntidadeNaoEncontradaException {
	public DoseNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public DoseNaoEncontradoException(Long id) {
		this(String.format("Não existe um Dose com o código %d", id));
	}
}
