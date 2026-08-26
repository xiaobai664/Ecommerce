package com.emcommerce.dto.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class OrderResponse {
	private BigInteger id;
	private String orderNo;
	private String Status;
}
