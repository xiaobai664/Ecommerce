package com.emcommerce.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
public class Order {
	private BigInteger id;
	private String orderNo;
	private BigInteger userId;
	private BigDecimal totalAmount;
	private String status;
	private String paymentMethod;
	private String payAt;
	private BigInteger receiverId;
	private String remark;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
