/**
 * Package: com.arvato.controller
 *
 * File: RedisMemberController.java 
 *
 * Author: Pactera   Date: 2016年7月6日
 *
 * Copyright © 2016 arvato
 *
 */
package com.mana.redisCache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mana.redisCache.model.RedisModel;
import com.mana.redisCache.service.RedisMemberService;

@Controller
@RequestMapping("/member")
public class RedisMemberController {
	
	@Autowired
	public RedisMemberService rservice;
	
	/**
	 * 添加
	 */
	@RequestMapping("/add")
	public String add(){
		RedisModel model  = new RedisModel("1","zqq");
		rservice.add(model);
		return "success";
	}
	
	/**
	 * 获取
	 */
	@RequestMapping("/get")
	@ResponseBody
	public RedisModel get(){
		String key = "1";
		RedisModel model = rservice.get(key);
		return model;
	}
	
}
