/**
 * Package: com.arvato.dao
 *
 * File: RedisGeneratorDao.java 
 *
 * Author: Pactera   Date: 2016年7月6日
 *
 * Copyright © 2016 arvato
 *
 */
package com.mana.redisCache.dao;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

@Component
public abstract class RedisGeneratorDao<K extends Serializable, V extends Serializable> {

	@Autowired
	protected StringRedisTemplate redisTemplate;

	/**
	 * 设置redisTemplate
	 * @param redisTemplate the redisTemplate to set
	 */
	public void setRedisTemplate(StringRedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	public StringRedisTemplate  getrRedisTemplate(){
		return redisTemplate;
	}

	/**
	 * 获取 RedisSerializer <br>
	 * ------------------------------<br>
	 */
	protected RedisSerializer<String> getRedisSerializer() {
		return redisTemplate.getStringSerializer();
	}

}
