package com.mana.threadDeam.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.hibernate.action.spi.Executable;

public class ThreadPool1 {
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		ExecutorService pool2 = Executors.newCachedThreadPool();
		
		
		ThreadDemo d1 = new ThreadDemo();
		ThreadDemo d2 = new ThreadDemo();
		ThreadDemo d3 = new ThreadDemo();
		ThreadDemo d4 = new ThreadDemo();
		ThreadDemo d5 = new ThreadDemo();
		
//		pool.execute(d1);
//		pool.execute(d2);
//		pool.execute(d3);
//		pool.execute(d4);
//		pool.execute(d5);
		
//		pool.shutdown();
		
		pool2.execute(d2);
		pool2.execute(d1);
		pool2.execute(d3);
		pool2.execute(d4);
		pool2.execute(d5);
		pool2.shutdown();
		
		
	}

}
