package com.juannobert.library.api.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.juannobert.library.api.services.exceptions.DatabaseException;
import com.juannobert.library.api.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public StandardError resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		var err =  new StandardError();
		HttpStatus status = HttpStatus.NOT_FOUND;
		err.setStatus(status.value());
		err.setTimestamp(Instant.now());
		err.setError("Resource not found");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return err;
	}
	
	@ExceptionHandler(DatabaseException.class)
	public StandardError database(DatabaseException e, HttpServletRequest request) {
		var err =  new StandardError();
		HttpStatus status = HttpStatus.BAD_REQUEST;
		err.setStatus(status.value());
		err.setTimestamp(Instant.now());
		err.setError("Integrity violation");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return err;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e, HttpServletRequest request){
		var err = new ValidationError();
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Resource not Found");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		
		for(FieldError field : e.getFieldErrors()) {
			err.add(field.getField(), field.getDefaultMessage());
		}
		return ResponseEntity.status(status).body(err);
	}
}
