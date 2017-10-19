package com.mana.threadDeam;

import java.util.concurrent.CountDownLatch;

class CountDownLatchDemo {
	
	public static void main(String[] args) {
		final CountDownLatch count = new CountDownLatch(2);
			
		new Thread(){
			public void run(){
				System.out.println("thread1 run start!");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("thread1 run finish!");
				count.countDown();
			}
		}.start();
		
		new Thread(){
			public void run(){
				System.out.println("thread2 run start!");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("thread2 run finish!");
				count.countDown();
			}
		}.start();
		
		System.out.println("main Thread wait 2 Thread");
		try {
			count.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main Thread finish");
	}

}
