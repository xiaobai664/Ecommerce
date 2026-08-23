package com.emcommerce.service.impl;

import com.emcommerce.entity.Product;
import com.emcommerce.mapper.ProductMapper;
import com.emcommerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
	private final ProductMapper productMapper;
	public ProductServiceImpl(ProductMapper productMapper){
		this.productMapper = productMapper;
	}
	@Override
	public Product getProductById(Long id){
		return productMapper.selectById(id);
	}

	@Override
	public List<Product> hotProductPage(int page, int count) {
		return null;
	}

	@Override
	public List<Product> newProductPage(int page, int count) {
		return null;
	}

	@Override
	public List<Product> getProductByName(String name) {
		return null;
	}

	@Override
	public int addNewProduct(Product product) {
		return 0;
	}

	@Override
	public int setProductCount(String method, BigDecimal count) {
		return 0;
	}

	@Override
	public int setProductPrice(String method, int count) {
		return 0;
	}
}
