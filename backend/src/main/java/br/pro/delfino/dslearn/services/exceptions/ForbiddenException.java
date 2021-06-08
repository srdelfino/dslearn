package br.pro.delfino.dslearn.services.exceptions;

// Http Status Code: 403
public class ForbiddenException extends RuntimeException {
	public ForbiddenException(String message) {
		super(message);
	}
}
