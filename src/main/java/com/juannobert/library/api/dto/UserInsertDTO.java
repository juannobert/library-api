package com.juannobert.library.api.dto;

import javax.validation.constraints.NotBlank;

public class UserInsertDTO extends UserDTO {

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "cannot be null")
	private String password;

	public UserInsertDTO() {
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
