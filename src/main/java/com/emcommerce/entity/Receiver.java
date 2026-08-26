package com.emcommerce.entity;

import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
public class Receiver {
	private BigInteger id;
	private BigInteger userId;
	private String receiverName;
	private String receiverPhone;
	private String receiverAddress;
	private boolean isDefault;
	private LocalDateTime createdAt;
}
