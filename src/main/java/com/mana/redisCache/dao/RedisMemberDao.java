/**
 * Package: com.arvato.dao
 *
 * File: RedisMemberDao.java 
 *
 * Author: Pactera   Date: 2016年7月6日
 *
 * Copyright © 2016 arvato
 *
 */
package com.mana.redisCache.dao;

import java.util.List;

import com.mana.redisCache.model.RedisModel;

public interface RedisMemberDao {
	boolean add(RedisModel member);

	abstract boolean add(List<RedisModel> list);

	void delete(String key);
	
	public void delete(List<String> keys);
	
	public boolean update(RedisModel model);

	RedisModel get(String keyId);
}
