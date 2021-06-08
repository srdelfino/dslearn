package br.pro.delfino.dslearn.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import br.pro.delfino.dslearn.services.exceptions.DatabaseException;
import br.pro.delfino.dslearn.services.exceptions.ForbiddenException;
import br.pro.delfino.dslearn.services.exceptions.ResourceNotFoundException;
import br.pro.delfino.dslearn.services.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public StandardError resourceNotFoundException (ResourceNotFoundException exception, HttpServletRequest request) {
		StandardError error = new StandardError();

		error.setTimestamp(Instant.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setError("Resource not found");
		error.setMessage(exception.getMessage());
		error.setPath(request.getRequestURI());

		return error;
	}	
	
	@ExceptionHandler(DatabaseException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public StandardError databaseException (DatabaseException exception, HttpServletRequest request) {
		StandardError error = new StandardError();

		error.setTimestamp(Instant.now());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setError("Database exception");
		error.setMessage(exception.getMessage());
		error.setPath(request.getRequestURI());

		return error;
	}	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	public ValidationError methodArgumentNotValidException (MethodArgumentNotValidException exception, HttpServletRequest request) {
		ValidationError error = new ValidationError();

		error.setTimestamp(Instant.now());
		error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		error.setError("Validation exception");
		error.setMessage(exception.getMessage());
		error.setPath(request.getRequestURI());

		exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
			error.addError(fieldError.getField(), fieldError.getDefaultMessage());
		});
		
		return error;
	}

	@ExceptionHandler(ForbiddenException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public OAuthCustomError forbiddenException (ForbiddenException exception, HttpServletRequest request) {
		OAuthCustomError error = new OAuthCustomError("Forbidden", exception.getMessage());
		return error;
	}

	@ExceptionHandler(UnauthorizedException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public OAuthCustomError unauthorizedException (UnauthorizedException exception, HttpServletRequest request) {
		OAuthCustomError error = new OAuthCustomError("Unauthorized", exception.getMessage());
		return error;
	}
}
