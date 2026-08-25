package com.emcommerce.service.impl;

import com.emcommerce.dto.request.RegisterRequest;
import com.emcommerce.entity.User;
import com.emcommerce.mapper.UserMapper;
import com.emcommerce.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

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
	public int setName(String name, BigInteger id) {
		User user = userMapper.selectByUsername(name);
		if (user!=null){
			throw new RuntimeException("用户名已存在");
		}
		userMapper.setName(name,id);
		return 0;
	}

	@Override
	public int setPassword(String password, BigInteger id) {
		User user = userMapper.selectById(id);
		if (user==null){
			throw new RuntimeException("用户不存在");
		}
		userMapper.setPassword(password,id);
		return 0;
	}

	@Override
	public int setPhone(String phone, BigInteger id) {
		User user = userMapper.selectByPhone(phone);
		if (user!=null){
			throw new RuntimeException("手机号已存在");
		}
		return userMapper.setPhone(phone,id);
	}

	@Override
	public User getUserData(BigInteger id) {
		User user = userMapper.selectById(id);
		if (user==null){
			throw new RuntimeException("用户不村在");
		}
		return user;
	}

	@Override
	public User getByPhone(String phone) {
		User user = userMapper.selectByPhone(phone);
		if (user==null){
			throw new RuntimeException("用户不存在");
		}
		return user;
	}

	@Override
	public User getByEmail(String email) {
		User user = userMapper.selectByEmail(email);
		if (user==null){
			throw new RuntimeException("用户不存在");
		}
		return user;
	}

}
