package com.emcommerce.service;

import com.emcommerce.dto.request.RegisterRequest;
import com.emcommerce.entity.User;

import java.math.BigInteger;

public interface UserService {
	void register(RegisterRequest request);

	int setName(String name, BigInteger id);

	int setPassword(String password,BigInteger id);

	int setPhone(String phone,BigInteger id);

	User getUserData(BigInteger id);

	User getByPhone(String phone);

	User getByEmail(String email);
}
