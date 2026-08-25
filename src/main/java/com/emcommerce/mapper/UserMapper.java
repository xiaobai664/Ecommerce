package com.emcommerce.mapper;

import com.emcommerce.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigInteger;

@Mapper
public interface UserMapper {
	@Select("SELECT id,username,password,email,phone,role,created_at,updated_at FROM users WHERE username=#{username}")
	User selectByUsername(String username);
	@Select("SELECT id,username,password,email,phone,role,created_at,updated_at FROM users WHERE id=#{id}")
	User selectById(BigInteger id);
	@Select("SELECT id,username,password,email,phone,role,created_at,updated_at FROM users WHERE phone=#{phone}")
	User selectByPhone(String phone);
	@Select("SELECT id,username,password,email,phone,role,created_at,updated_at FROM users WHERE email=#{email}")
	User selectByEmail(String email);
	@Insert("INSERT INTO users (username,password,email,phone,role) VALUES (#{username},#{password},#{email},#{phone},#{role})")
	int insert(User user);
	@Update("UPDATE users SET username=#{name} WHERE id=#{id}")
	int setName(String name, BigInteger id);
	@Update("UPDATE users SET password=#{password} WHERE id=#{id}")
	int setPassword(String password,BigInteger id);
	@Update("UPDATE users SET phone=#{phone} WHERE id=#{id}")
	int setPhone(String phone,BigInteger id);
}
