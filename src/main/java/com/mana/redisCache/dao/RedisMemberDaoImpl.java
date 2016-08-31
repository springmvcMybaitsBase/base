/**
 * Package: com.arvato.dao
 *
 * File: RedisMemberDaoImpl.java 
 *
 * Author: Pactera   Date: 2016年7月6日
 *
 * Copyright © 2016 arvato
 *
 */
package com.mana.redisCache.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.mana.redisCache.model.RedisModel;

@Repository
public class RedisMemberDaoImpl extends RedisGeneratorDao<String, RedisModel> implements RedisMemberDao{
	/**
	 * 添加对象
	 */
	public boolean add(final RedisModel model) {
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException{
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(model.getId());
				byte[] name = serializer.serialize(model.getNickname());
				return connection.setNX(key, name);
			};
		});
		return result;
	}
	
	/**
	 * 添加集合
	 */
	public boolean add(final List<RedisModel> models){
		Assert.notEmpty(models);
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				for(RedisModel model:models){
					byte[] key = serializer.serialize(model.getId());
					byte[] name = serializer.serialize(model.getNickname());
					connection.setNX(key, name);
				}
				return true;  
			}
		},false,true);
		return result;
	}
	
	/**
	 * 删除对象，依赖key
	 */
	public void delete(String key){
		List<String> list = new ArrayList<String>();  
        list.add(key);
        delete(list);
	}
	
	/**
	 * 删除集合
	 */
	public void delete(List<String> keys){
		redisTemplate.delete(keys);
	}
	
	/**
	 * 修改对象 
	 */
	public boolean update(final RedisModel model){
		String key = model.getId();
		if(get(key) == null){
			throw new NullPointerException("数据行不存在, key = " + key);  
		}
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException{
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(model.getId());
				byte[] value = serializer.serialize(model.getNickname());
				connection.set(key, value);
				return true;
			}
		});
		return result;
	}
	
	/**
	 * 根据key获取对象
	 */
	public RedisModel get(final String keyId){
		RedisModel model = redisTemplate.execute(new RedisCallback<RedisModel>() {
			public RedisModel doInRedis(RedisConnection connection) throws  DataAccessException{
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(keyId);  
				byte[] value = connection.get(key);
				if(value == null){
					return null;
				}
				String nickName = serializer.deserialize(value);
				return new RedisModel(keyId,nickName);
			}
		});
		return model;
	}

}
