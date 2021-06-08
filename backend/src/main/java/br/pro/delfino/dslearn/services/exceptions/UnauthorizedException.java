package br.pro.delfino.dslearn.services.exceptions;

// Http Status Code: 401
public class UnauthorizedException extends RuntimeException {
	public UnauthorizedException(String message) {
		super(message);
	}
}
