/**
 * Package: com.arvato.decorator
 *
 * File: DecoratorTest.java 
 *
 * Author: Pactera   Date: 2016年7月7日
 *
 * Copyright © 2016 arvato
 *
 */
package com.mana.decorator.decorator;


public class DecoratorTest {
	public static void main(String[] args) {
		Humburger humburger = new ChickHumburger();
		System.out.println(humburger.getName()+"  价钱："+humburger.getPrice());  
		DecoratorOne one = new DecoratorOne(humburger); 
		System.out.println(one.getName()+"  价钱："+one.getPrice()); 
		DecoratorTwo two = new DecoratorTwo(humburger);
		System.out.println(two.getName()+"  价钱："+two.getPrice());
		DecoratorThree three = new DecoratorThree(humburger);
		System.out.println(three.getName()+"  价钱："+three.getPrice());
		DecoratorThree three1 = new DecoratorThree(new DecoratorTwo(new DecoratorOne(humburger)));
		System.out.println(three1.getName()+"  价钱："+three1.getPrice());
	}
}
