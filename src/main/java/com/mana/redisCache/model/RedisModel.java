package com.mana.redisCache.model;

import java.io.Serializable;

/**
 * Package:
 *
 * File: RedisModel.java
 *
 * Author: Pactera Date: 2016年7月6日
 *
 * Copyright © 2016 arvato
 *
 */

public class RedisModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String nickname;

	public RedisModel() {
	}

	public RedisModel(String id, String nickname) {
		this.setId(id);
		this.setNickname(nickname);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
