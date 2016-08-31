/**
 * Package: com.mana.redisCache.service
 *
 * File: CacheRedisServicw.java 
 *
 * Author: Pactera   Date: 2016年7月19日
 *
 * Copyright © 2016 arvato
 *
 */
package com.mana.redisCache.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mana.redisCache.mapper.CacheRedisMapper;
import com.mana.redisCache.model.CacheRedisModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CacheRedisService {
	
	@Autowired
	private CacheRedisMapper mapper;
	
	@Transactional
	public void add(CacheRedisModel model){
		mapper.add(model);
	}

	public List<CacheRedisModel> getAll(){
		return mapper.getAll();
	}

	public CacheRedisModel getById(int id){
		return mapper.getById(id);
	}
}
