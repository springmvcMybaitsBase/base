/**
 * Package: com.arvato.decorator
 *
 * File: Humburger.java 
 *
 * Author: Pactera   Date: 2016年7月7日
 *
 * Copyright © 2016 arvato
 *
 */
package com.mana.decorator.decorator;


/**
 * 汉堡的基础类，被装饰者
 */
public abstract class Humburger {
	
	protected String name;
	
	public String getName(){
		return name;
	}
	
	public abstract double getPrice();
}
