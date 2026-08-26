package com.emcommerce.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class PageResponse<T> {
	private List<T>records;
	private Long total;
	private int page;
	private int size;
	private int pages;
}
