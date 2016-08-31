/**
 * Package: com.mana.redisCache.controller
 *
 * File: RedisCacheController.java 
 *
 * Author: Pactera   Date: 2016年7月19日
 *
 * Copyright © 2016 arvato
 *
 */
package com.mana.redisCache.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mana.redisCache.model.CacheRedisModel;
import com.mana.redisCache.service.CacheRedisService;

@Slf4j
@Controller
@RequestMapping("/cache/redis")
public class RedisCacheController {

	@Autowired
	private CacheRedisService service;

	@RequestMapping("/add")
	@ResponseBody
	public String add() {
		CacheRedisModel model1 = new CacheRedisModel("test1", "12345");
		CacheRedisModel model2 = new CacheRedisModel("test2", "123456789");
		service.add(model1);
		service.add(model2);
		return "success";
	}

	@RequestMapping("/get")
	@ResponseBody
	public List<CacheRedisModel> get() {
		List<CacheRedisModel> models = service.getAll();
		return models;
	}

}
