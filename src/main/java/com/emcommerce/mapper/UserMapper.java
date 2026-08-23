package com.emcommerce.mapper;

import com.emcommerce.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
	@Select("SELECT id,username,password,email,phone,role,created_at,updated_at FROM users WHERE username=#{username}")
	User selectByUsername(String username);
	@Insert("INSERT INTO users (username,password,email,phone,role) VALUES (#{username},#{password},#{email},#{phone},#{role})")
	int insert(User user);
}
