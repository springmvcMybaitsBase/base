package com.mana.threadDeam.hasReturnValueThreadDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo1 {
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		MyCallable m1 = new MyCallable("111");
		MyCallable m2 = new MyCallable("222");
		MyCallable m3 = new MyCallable("333");
		MyCallable m4 = new MyCallable("444");
		
		 Future f1 = pool.submit(m1);
		 try {
			System.out.println(f1.get().toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
}

class MyCallable implements Callable{
	
	private String aid = "";
	
	public MyCallable(String aid){
		this.aid = aid;
	}

	public Object call() throws Exception {
		aid = aid + "-test";
		return "返回值："+aid;
	}
}