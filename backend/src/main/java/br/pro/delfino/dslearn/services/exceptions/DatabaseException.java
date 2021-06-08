package br.pro.delfino.dslearn.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class DatabaseException extends RuntimeException {
	public DatabaseException(String message) {
		super(message);
	}
}
