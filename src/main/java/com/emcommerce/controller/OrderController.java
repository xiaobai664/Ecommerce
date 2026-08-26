package com.emcommerce.controller;

import com.emcommerce.dto.request.CreateOrderRequest;
import com.emcommerce.dto.response.ApiResponse;
import com.emcommerce.dto.response.OrderResponse;
import com.emcommerce.dto.response.PageResponse;
import com.emcommerce.entity.Order;
import com.emcommerce.service.OrderService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;


@RestController
@RequestMapping("/order")
public class OrderController {
	private final OrderService orderService;
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping("/create")
	public ApiResponse<OrderResponse> createOrder(Authentication authentication){
		BigInteger userId = BigInteger.valueOf(Long.valueOf(authentication.getName()));
		OrderResponse orderResponse = orderService.createOrder(userId);
		return new ApiResponse<>(200,"创建新订单成功",orderResponse);
	}
	@GetMapping("/orders")
	public ApiResponse<PageResponse<OrderResponse>> getOrder(Authentication authentication, @RequestParam(defaultValue = "1")int page,@RequestParam(defaultValue = "10")int size){
		BigInteger userId = BigInteger.valueOf(Long.valueOf(authentication.getName()));
		PageResponse<OrderResponse> response = orderService.getOrders(userId,page,size);
		return new ApiResponse<>(200,"获得信息成功",response);
	}
	@PostMapping("/add")
	public ApiResponse<Void> addItem(Authentication authentication){
		return new ApiResponse<>(200,"添加成功",null);
	}

}
