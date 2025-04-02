package com.Login.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponceDto {

	private String username;
	private String password;
	private String role;
	
}
