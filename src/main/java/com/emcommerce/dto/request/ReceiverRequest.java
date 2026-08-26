package com.emcommerce.dto.request;

import lombok.Data;

@Data
public class ReceiverRequest {
	private String name;
	private String phone;
	private String address;
	private boolean isDefault;
}
