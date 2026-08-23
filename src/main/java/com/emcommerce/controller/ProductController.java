package com.emcommerce.controller;

import com.emcommerce.entity.Product;
import com.emcommerce.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable Long id){
		return productService.getProductById(id);
	}

	@GetMapping("/hello")
	public String hello(){
		return "hello Spring Boot";
	}
}
