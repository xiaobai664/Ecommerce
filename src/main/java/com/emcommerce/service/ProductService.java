package com.emcommerce.service;

import com.emcommerce.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
	Product getProductById(Long id);

	List<Product> hotProductPage(int page,int count);

	List<Product> newProductPage(int page,int count);

	List<Product> getProductByName(String name);

	int addNewProduct(Product product);

	int setProductCount(String method, BigDecimal count);

	int setProductPrice(String method,int count);
}
