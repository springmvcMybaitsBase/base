package com.mana.threadDeam;

public class FooThreadMain {
	
	public static void main(String[] args) {
		FooDemo demo = new FooDemo();
		Thread t1 = new Thread(new FooThreadDemo1(demo));
		Thread t2 = new Thread(new FooThreadDemo2(demo));
		
		t1.start();
		t2.start();
	}

}
