package com.emcommerce.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class VerifyCodeService {
	private final RedisTemplate<String,String> redisTemplate;

	public VerifyCodeService(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void saveCode(String identifier,String code){
		String key="verify:code:"+identifier;
		redisTemplate.opsForValue().set(key,code,Duration.ofMinutes(5));
	}

	public String getCode(String identifier){
		String key="verify:code:"+identifier;
		return redisTemplate.opsForValue().get(key);
	}
}
