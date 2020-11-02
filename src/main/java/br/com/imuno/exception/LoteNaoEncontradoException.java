package br.com.imuno.exception;

@SuppressWarnings("serial")
public class LoteNaoEncontradoException extends EntidadeNaoEncontradaException {
	public LoteNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public LoteNaoEncontradoException(Long id) {
		this(String.format("Não existe um Lote com o código %d", id));
	}
}
