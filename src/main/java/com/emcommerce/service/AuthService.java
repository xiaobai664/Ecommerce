package com.emcommerce.service;

import com.emcommerce.dto.request.LoginRequest;
import com.emcommerce.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
	private final UserService userService;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;

	public AuthService(UserService userService, PasswordEncoder passwordEncoder, JwtService jwtService) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
	}

	public String login(LoginRequest loginRequest){
		String identifier = loginRequest.getIdentifier();
		User user;
		if (identifier.contains("@")){
			user = userService.getByEmail(identifier);
		}else {
			user = userService.getByPhone(identifier);
		}
		if(user==null){
			throw new RuntimeException("用户不存在");
		}
		if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
			throw new RuntimeException("密码错误");
		}
		return jwtService.generateToken(user);
	}
}
