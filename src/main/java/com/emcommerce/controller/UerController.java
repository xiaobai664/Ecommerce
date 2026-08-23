package com.emcommerce.controller;

import com.emcommerce.dto.request.RegisterRequest;
import com.emcommerce.dto.response.ApiResponse;
import com.emcommerce.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UerController {
	private final UserService userService;

	public UerController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public ApiResponse<Void> register(@RequestBody RegisterRequest request){
		userService.register(request);
		return new ApiResponse<>(200,"注册成功",null);
	}

}
