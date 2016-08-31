/**
 * Package: com.arvato.decorator
 *
 * File: DecoratorTwo.java 
 *
 * Author: Pactera   Date: 2016年7月7日
 *
 * Copyright © 2016 arvato
 *
 */
package com.mana.decorator.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * 加鸡蛋
 */
public class DecoratorTwo extends Decorator{

	public DecoratorTwo(Humburger humburger) {
		super(humburger);
	}
	
	public String getName(){
		return humburger.getName() + "加鸡蛋";
	}
	
	public double getPrice(){
		return humburger.getPrice() + 2;
	}
	
}
