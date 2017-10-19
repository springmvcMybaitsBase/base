package com.mana.threadDeam;

public class FooThreadDemo2 implements Runnable{

	private FooDemo demo;
	
	public FooThreadDemo2(FooDemo demo){
		this.demo = demo;
	}
	
	public void run(){
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		demo.reduceX();
		System.out.println(demo.getX());
	}
}
