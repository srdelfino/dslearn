package br.pro.delfino.dslearn.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UnauthorizedException extends RuntimeException {
	public UnauthorizedException(String message) {
		super(message);
	}
}
