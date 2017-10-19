package com.mana.threadDeam;

public class ThreadJoinDemo {
	
	public static void main(String[] args) {
		ThradDemot  demo = new ThradDemot();
		demo.start();
		for(int i=0;i<10;i++){
			System.out.println("main:"+i);
			try {
				Thread.sleep(30);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			if(i>=2){
				try {
					demo.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}

class ThradDemot extends Thread{
	public void run(){
		for(int i=1;i<=5;i++){
			try {
				Thread.sleep(30);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println("执行线程A："+i);
		}
	}
}
