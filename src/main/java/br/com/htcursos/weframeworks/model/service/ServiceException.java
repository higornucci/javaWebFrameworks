package br.com.htcursos.weframeworks.model.service;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ServiceException(String mensagem) {
		super(mensagem);
	}
	
	public ServiceException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
	public ServiceException(Throwable causa) {
		super(causa);
	}
}
