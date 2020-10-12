package br.com.imuno.exception;

public class FuncionarioNaoEncontradoException extends EntidadeNaoEncontradaException {
	
	public FuncionarioNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public FuncionarioNaoEncontradoException(Long id) {
		this(String.format("Não existe um cadastro de funcionário com o código %d", id));
	}

}
