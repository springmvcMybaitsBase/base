package com.mana.threadDeam;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	
	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(7, new MainTask()); 
        new SubTask("A", cb).start(); 
        new SubTask("B", cb).start(); 
        new SubTask("C", cb).start(); 
        new SubTask("D", cb).start(); 
        new SubTask("E", cb).start(); 
        new SubTask("F", cb).start(); 
        new SubTask("G", cb).start();
        System.out.println("main task");

	}
}

class MainTask implements Runnable{
	
	public void run(){
		 System.out.println(">>>>主任务执行了！<<<<"); 
	}
	
}

class SubTask extends Thread{
	private String name;
	private CyclicBarrier cb;
	
	public SubTask(String name,CyclicBarrier cb){
		this.name = name;
		this.cb = cb;
	}
	public void run(){
		System.out.println("[子任务" + name + "]开始执行了！"); 
		for (int i = 0; i < 10; i++) ;    //模拟耗时的任务
		System.out.println("[子任务" + name + "]开始执行完成了，并通知障碍器已经完成！");
		 try {
			cb.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
