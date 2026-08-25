package com.emcommerce.controller;

import com.emcommerce.dto.request.PhoneRequest;
import com.emcommerce.dto.request.RegisterRequest;
import com.emcommerce.dto.response.ApiResponse;
import com.emcommerce.dto.response.UserResponse;
import com.emcommerce.entity.User;
import com.emcommerce.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.net.Authenticator;

@RestController
@RequestMapping("/user")
public class UerController {
	private final UserService userService;

	public UerController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/me")
	public ApiResponse<UserResponse> getCurrentUser(Authentication authentication){
		BigInteger userId = BigInteger.valueOf(Long.valueOf(authentication.getName()));
		User user = userService.getUserData(userId);
		UserResponse response = new UserResponse(
				user.getId(),
				user.getUsername(),
				user.getEmail(),
				user.getPhone(),
				user.getRole()
		);
		return new ApiResponse<>(200,"获取成功", response);
	}

	@PostMapping("/phone")
	public ApiResponse<Void> setPhone(Authentication authentication,@RequestBody PhoneRequest phoneRequest){
		BigInteger userId = BigInteger.valueOf(Long.valueOf(authentication.getName()));
		User user = userService.getUserData(userId);
		if (user==null){
			throw new RuntimeException("没有此用户");
		}
		userService.setPhone(phoneRequest.getPhone(), userId);
		return new ApiResponse<>(200,"修改手机号成功",null);
	}
}
