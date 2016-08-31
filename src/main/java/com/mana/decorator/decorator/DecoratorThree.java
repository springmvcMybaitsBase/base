/**
 * Package: com.arvato.decorator
 *
 * File: DecoratorThree.java 
 *
 * Author: Pactera   Date: 2016年7月7日
 *
 * Copyright © 2016 arvato
 *
 */
package com.mana.decorator.decorator;


/**
 * 加辣椒
 */
public class DecoratorThree extends Decorator{

	public DecoratorThree(Humburger humburger) {
		super(humburger);
	}
	
	public String getName(){
		return humburger.getName() + "加辣椒";
	}
	
	public double getPrice(){
		System.out.println("免费加辣椒的！");
		return humburger.getPrice();
	}

	
}
