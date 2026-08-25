package com.emcommerce.controller;

import com.emcommerce.dto.request.CodeRequest;
import com.emcommerce.dto.request.LoginRequest;
import com.emcommerce.dto.request.RegisterRequest;
import com.emcommerce.dto.response.ApiResponse;
import com.emcommerce.service.AuthService;
import com.emcommerce.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
	private final UserService userService;
	private final AuthService authService;

	public AuthController(UserService userService, AuthService authService) {
		this.userService = userService;
		this.authService = authService;
	}
	@PostMapping("/register")
	public ApiResponse<Void> register(@RequestBody RegisterRequest request){
		userService.register(request);
		return new ApiResponse<>(200,"注册成功",null);
	}
	
	@PostMapping("/login")
	public ApiResponse<String> login(@RequestBody LoginRequest loginRequest){
		String token = authService.login(loginRequest);
		return new ApiResponse<>(200,"登录成功",token);
	}

	@PostMapping("/code/send")
	public ApiResponse<Void> sendCode(@RequestBody CodeRequest CodeRequest){
		//添加发送验证码的服务
		return new ApiResponse<>(200,"发送验证码成功",null);
	}
	@PostMapping("/code/check")
	public ApiResponse<Void> checkCode(@RequestBody CodeRequest codeRequest){
		//添加验证校验码的服务
		return new ApiResponse<>(200,"验证成功",null);
	}
}
