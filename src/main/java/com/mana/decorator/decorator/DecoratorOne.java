/**
 * Package: com.arvato.decorator
 *
 * File: DecoratorOne.java 
 *
 * Author: Pactera   Date: 2016年7月7日
 *
 * Copyright © 2016 arvato
 *
 */
package com.mana.decorator.decorator;


/**
 * 加生菜
 */
public class DecoratorOne extends Decorator{
	
	public DecoratorOne(Humburger humburger) {
		super(humburger);
	}
	
	public String getName(){
		return humburger.getName() + "加生菜";
	}
	
	public double getPrice(){
		return humburger.getPrice() + 1;
	}
}
