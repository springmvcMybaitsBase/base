/**
 * Package: com.mana.redisCache.mapper
 *
 * File: CacheRedisMapper.java 
 *
 * Author: Pactera   Date: 2016年7月19日
 *
 * Copyright © 2016 arvato
 *
 */
package com.mana.redisCache.mapper;

import java.util.List;

import com.mana.redisCache.model.CacheRedisModel;

public interface CacheRedisMapper {
	
	void add(CacheRedisModel model);
	
	List<CacheRedisModel> getAll();
	
	CacheRedisModel getById(int id);
}
