package br.com.imuno.exception;

@SuppressWarnings("serial")
public class PostoNaoEncontradoException extends EntidadeNaoEncontradaException {

	public PostoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public PostoNaoEncontradoException(Long id) {
		this(String.format("Não existe um cadastro de posto com o código %d", id));
	}

}
