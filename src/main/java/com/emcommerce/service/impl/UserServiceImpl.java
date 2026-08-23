package com.emcommerce.service.impl;

import com.emcommerce.dto.request.RegisterRequest;
import com.emcommerce.entity.User;
import com.emcommerce.mapper.UserMapper;
import com.emcommerce.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserMapper userMapper, PasswordEncoder passwordEncoder) {
		this.userMapper = userMapper;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void register(RegisterRequest request) {
		User existUser = userMapper.selectByUsername(request.getUsername());
		if (existUser!=null){
			throw new RuntimeException("用户名已存在");
		}
		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setEmail(request.getEmail());
		user.setRole("USER");
		userMapper.insert(user);
	}

	@Override
	public int setName(String name) {
		return 0;
	}

	@Override
	public int setPassword(String password) {
		return 0;
	}
}
