package com.mana.threadDeam;

public class ThreadB implements Runnable{
	
	public void run(){
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		synchronized (this) {
			System.out.println("start ThreadB");
			System.out.println("finish ThreadB");
			notifyAll();
		}
	}
}
