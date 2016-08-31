/**
 * Package: com.arvato.decorator
 *
 * File: ChickHumburger.java 
 *
 * Author: Pactera   Date: 2016年7月7日
 *
 * Copyright © 2016 arvato
 *
 */
package com.mana.decorator.decorator;


/**
 * 鸡腿堡：集成汉堡，有自己的一些特性，有一些基本的特性
 * 被修饰类
 */
public class ChickHumburger extends Humburger{

	public ChickHumburger() {
		name="鸡腿堡";
	}
	
	@Override
	public double getPrice() {
		return 10;
	}
	

}
