package br.com.imuno.exception;

@SuppressWarnings("serial")
public class CadernetaNaoEncontradoException extends EntidadeNaoEncontradaException {

	public CadernetaNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public CadernetaNaoEncontradoException(Long id) {
		this(String.format("Não existe uma Caderneta com o código %d", id));
	}
	
}
