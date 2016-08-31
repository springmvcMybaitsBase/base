/**
 * Package: com.arvato.redisCatch
 *
 * File: RedisCacheTransfer.java 
 *
 * Author: Pactera   Date: 2016年7月8日
 *
 * Copyright © 2016 arvato
 *
 */
package com.mana.redisCache.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;


public class RedisCacheTransfer {
	@Autowired
    public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        RedisCache.setJedisConnectionFactory(jedisConnectionFactory);
    }
}
