package com.emcommerce.dto.response;

import lombok.Data;

@Data
public class UserResponse {
	private Long Id;
	private String username;
	private String email;
	private String phone;
	private String role;

	public UserResponse(Long id, String username, String email, String phone, String role) {
		this.Id = id;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.role = role;
	}
}
