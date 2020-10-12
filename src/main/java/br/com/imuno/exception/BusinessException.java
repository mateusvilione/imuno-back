package br.com.imuno.exception;

public class BusinessException extends RuntimeException {
	
	public static final long serialVersionUID = 1L;
	
	public BusinessException() {
		super();
	}
	
	public BusinessException(String message) {
		super(message);
	}

}
