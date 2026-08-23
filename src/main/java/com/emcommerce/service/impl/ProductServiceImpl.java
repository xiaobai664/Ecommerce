package com.emcommerce.service.impl;

import com.emcommerce.entity.Product;
import com.emcommerce.mapper.ProductMapper;
import com.emcommerce.service.ProductService;
import org.springframework.stereotype.Service;

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
}
