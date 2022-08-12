package com.juannobert.library.api.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable{

	private static final long serialVersionUID = 1L;

	private Instant timestamp;
	
	private Integer status;
	
	private String path;
	
	private String error;
	
	private String message;
	
	public StandardError() {
	}

	public StandardError(Instant timestamp, Integer status, String path, String error, String message) {
		this.timestamp = timestamp;
		this.status = status;
		this.path = path;
		this.error = error;
		this.message = message;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
