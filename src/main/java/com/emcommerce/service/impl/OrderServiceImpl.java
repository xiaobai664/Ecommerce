package com.emcommerce.service.impl;

import com.emcommerce.dto.response.OrderResponse;
import com.emcommerce.dto.response.PageResponse;
import com.emcommerce.entity.Order;
import com.emcommerce.mapper.OrderMapper;
import com.emcommerce.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class OrderServiceImpl implements OrderService {
	private final OrderMapper orderMapper;

	public OrderServiceImpl(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}

	@Transactional
	@Override
	public OrderResponse createOrder(BigInteger user_id) {
		Order order = new Order();
		order.setUserId(user_id);
		order.setOrderNo(generateOrderNo());
		order.setTotalAmount(BigDecimal.valueOf(0.0));
		order.setStatus("PENDING_PAYMENT");

		orderMapper.createOrder(order);

		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setId(order.getId());
		orderResponse.setOrderNo(order.getOrderNo());
		orderResponse.setStatus(order.getStatus());

		return orderResponse;
	}

	@Override
	public PageResponse<OrderResponse> getOrders(BigInteger userId, int page, int size) {
		page = Math.max(page, 1);
		size = Math.max(Math.min(size, 50), 10);

		int offset = (page - 1) * size;
		List<Order> orders = orderMapper.getOrdersByUserId(userId, size, offset);
		long total = orderMapper.countOrdersByUserId(userId);
		int totalPages = (int) Math.ceil((double) total / size);

		List<OrderResponse> orderResponses = orders.stream()
				.map(order -> {
					OrderResponse response = new OrderResponse();
					response.setId(order.getId());
					response.setOrderNo(order.getOrderNo());
					response.setStatus(order.getStatus());
					return response;
				}).toList();

		PageResponse<OrderResponse> response = new PageResponse<>();
		response.setRecords(orderResponses);
		response.setTotal(total);
		response.setPage(page);
		response.setSize(size);
		response.setPages(totalPages);

		return response;
	}


	@Override
	public int addItemToOrder(BigInteger order_id, BigInteger product_id, Integer quantity) {
		return 0;
	}

	@Override
	public int cancelOrder(BigInteger userId, BigInteger orderId) {
		return 0;
	}

	@Override
	public int payOrder(BigInteger userId, BigInteger orderId) {
		return 0;
	}

	@Override
	public OrderResponse getOrder(BigInteger userId, BigInteger orderId) {
		return null;
	}

	public String generateOrderNo() {
		String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		String random = String.format("%04d", ThreadLocalRandom.current().nextInt(10000));
		return time + random;
	}
}
