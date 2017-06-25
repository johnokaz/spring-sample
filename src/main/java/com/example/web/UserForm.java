package com.example.web;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserForm {
	@NotNull
	@Size(min = 1, max = 127)
	private String username;
	@NotNull
	@Size(min = 1, max = 127)
	private String password;
	@NotNull
    @Size(min = 1, max = 127)
    private String firstname;
    @NotNull
    @Size(min = 1, max = 127)
    private String lastname;
    @NotNull
    @Size(min = 1, max = 127)
    private String mail;
}
