package com.emcommerce.service;

import com.emcommerce.dto.response.OrderResponse;
import com.emcommerce.dto.response.PageResponse;
import com.emcommerce.entity.Order;
import org.springframework.data.domain.Page;

import java.math.BigInteger;

public interface OrderService {
	OrderResponse createOrder(BigInteger user_id);

	public PageResponse<OrderResponse> getOrders(BigInteger user_id, int page, int size);

	int addItemToOrder(BigInteger order_id, BigInteger product_id, Integer quantity);

	int cancelOrder(BigInteger userId, BigInteger orderId);

	int payOrder(BigInteger userId, BigInteger orderId);

	OrderResponse getOrder(BigInteger userId, BigInteger orderId);
}
