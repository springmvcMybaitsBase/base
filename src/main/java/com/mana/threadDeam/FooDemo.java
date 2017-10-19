package com.mana.threadDeam;

public class FooDemo {
	
	private int x;
	
	public int getX(){
		return x;
	}
	
	public synchronized void reduceX(){
		x -= 1;
	}
}
