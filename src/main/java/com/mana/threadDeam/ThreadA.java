package com.mana.threadDeam;

public class ThreadA {
	
	public static void main(String[] args) {
		System.out.println("start threadA");
		ThreadB br  = new ThreadB();
		new Thread(br).start();
		new Thread(br).start();
		new Thread(br).start();
		synchronized (br) {
			try {
				br.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(" finish threadA");
		
	}

}
