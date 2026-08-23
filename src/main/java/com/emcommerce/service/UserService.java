package com.emcommerce.service;

import com.emcommerce.dto.request.RegisterRequest;

public interface UserService {
	void register(RegisterRequest request);

	int setName(String name);

	int setPassword(String password);


}
