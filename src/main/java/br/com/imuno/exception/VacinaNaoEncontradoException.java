package br.com.imuno.exception;

@SuppressWarnings("serial")
public class VacinaNaoEncontradoException extends EntidadeNaoEncontradaException {
	public VacinaNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public VacinaNaoEncontradoException(Long id) {
		this(String.format("Não existe um Vacina com o código %d", id));
	}
}
