/**
 * Package: com.mana.redisCache.model
 *
 * File: TestCacheRedis.java 
 *
 * Author: Pactera   Date: 2016年7月19日
 *
 * Copyright © 2016 arvato
 *
 */
package com.mana.redisCache.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
@ToString
public class CacheRedisModel implements  Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String mobile;
	
	public CacheRedisModel(){}
	public CacheRedisModel(String name,String mobile){
		this.name = name;
		this.mobile = mobile;
	}

}
