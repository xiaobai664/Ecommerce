package com.emcommerce.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Product {
	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	private Integer stock;
	private Long categoryId;
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
}
