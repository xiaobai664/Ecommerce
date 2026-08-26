package com.emcommerce.dto.request;

import lombok.Data;

import java.math.BigInteger;

@Data
public class CreateOrderRequest {
	private BigInteger uerId;
}
