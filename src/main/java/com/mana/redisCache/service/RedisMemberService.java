/**
 * Package: com.arvato.service
 *
 * File: RedisMemberService.java 
 *
 * Author: Pactera   Date: 2016年7月6日
 *
 * Copyright © 2016 arvato
 *
 */
package com.mana.redisCache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mana.redisCache.dao.RedisMemberDao;
import com.mana.redisCache.model.RedisModel;

@Service(value="rservice")
public class RedisMemberService {
	
	@Autowired
	private RedisMemberDao redisMemberDao;
	
	@CacheEvict(value = { "models"}, allEntries = true)  
	public void add(RedisModel member){
		redisMemberDao.add(member);
    }
	
	@Cacheable("models") 
	public RedisModel get(String key){
		return redisMemberDao.get(key);
	}
}
