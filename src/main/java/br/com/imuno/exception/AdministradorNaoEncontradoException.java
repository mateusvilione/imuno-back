package br.com.imuno.exception;

@SuppressWarnings("serial")
public class AdministradorNaoEncontradoException extends EntidadeNaoEncontradaException {

	public AdministradorNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public AdministradorNaoEncontradoException(Long id) {
		this(String.format("Não existe um Administrador de posto com o código %d", id));
	}
	
}
