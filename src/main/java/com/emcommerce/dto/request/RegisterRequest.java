package com.emcommerce.dto.request;

import lombok.Data;

@Data
public class RegisterRequest {
	private String Username;
	private String password;
	private String email;
	private String phone;
}
