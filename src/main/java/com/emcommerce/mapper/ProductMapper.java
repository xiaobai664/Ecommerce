package com.emcommerce.mapper;

import com.emcommerce.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
	@Select("SElECT id,name,description,price,stock,category_id,created_at,updated_at FROM product WHERE id = #{id}")
	Product selectById(Long id);
	@Select("SElECT id,name,description,price,stock,category_id,created_at,updated_at FROM product")
	List<Product> selectAll();
	@Insert("INSERT INTO product (name,description,price,stock,category_id) VALUES (#{name},#{description},#{price},#{stock},#{categoryId})")
	int insert(Product product);
	@Update("UPDATE product SET name=#{name},description=#{description},stock=#{stock},category_id=#{categoryId} WHERE id =#{id}")
	int update(Product product);
	@Delete("DELETE FROM product WHERE id=#{id}")
	int deleteById(Long id);
}

