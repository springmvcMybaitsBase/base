/**
 * Package: com.arvato.redisCatch
 *
 * File: RedisCacheConfig.java 
 *
 * Author: Pactera   Date: 2016年7月11日
 *
 * Copyright © 2016 arvato
 *
 */
package com.mana.redisCache.common;

import java.io.Serializable;
import java.lang.reflect.Method;

import lombok.extern.slf4j.Slf4j;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Slf4j
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

//	@Bean
//	public JedisConnectionFactory redisConnectionFactory() {
//		JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
//		redisConnectionFactory.setHostName("127.0.0.1");
//		redisConnectionFactory.setPort(6379);
//		return redisConnectionFactory;
//	}

	@Bean
	public RedisTemplate<Serializable, Serializable> redisTemplate(
			RedisConnectionFactory factory) {
		RedisTemplate<Serializable, Serializable> redisTemplate = new RedisTemplate<Serializable, Serializable>();
		redisTemplate.setConnectionFactory(factory);
		return redisTemplate;
	}

	@Bean
	public CacheManager cacheManager(RedisTemplate redisTemplate) {
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
		//这里可以设置一个默认的过期时间
		cacheManager.setDefaultExpiration(3000);
		return cacheManager;
	}

	/**
	 * key生成策略的定义
	 * @return
	 */
	@Bean
	public KeyGenerator customKeyGenerator() {
		return new KeyGenerator() {
			public Object generate(Object o, Method method, Object... params) {
				StringBuilder sb = new StringBuilder();
				sb.append(o.getClass().getName());
				sb.append(method.getName());
				for (Object obj : params) {
					sb.append(obj.toString());
				}
				return sb.toString();
			}
		};
	}

}
