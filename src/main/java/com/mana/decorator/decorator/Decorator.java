/**
 * Package: com.arvato.decorator
 *
 * File: Decorator.java 
 *
 * Author: Pactera   Date: 2016年7月7日
 *
 * Copyright © 2016 arvato
 *
 */
package com.mana.decorator.decorator;


/**
 * 基本装饰类：拥有一些基本功能
 */
public abstract class Decorator extends Humburger{
	
	protected Humburger humburger;
	
	public Decorator(Humburger humburger){
		this.humburger = humburger;
	}
	
	public String getName(){
		return humburger.getName();
	}
	
	public double getPrice(){
		return humburger.getPrice();
	};
}
