package com.mana.threadDeam.pool;

public class ThreadDemo extends Thread{
	
	public ThreadDemo(){}
	
	public ThreadDemo(String name){
		super(name);
	}

	public void run(){
		System.out.println(Thread.currentThread().getName() + " is run ");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
}
