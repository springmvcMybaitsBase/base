package com.mana.threadDeam.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DefineMyselfThreadPool {
	
	public static void main(String[] args) {
		
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(2);
		
		/** 
         * 1.在使用有界队列的时候：若有新的任务需要执行，如果线程池实际线程数小于corePoolSize核心线程数的时候，则优先创建线程。 
         * 若大于corePoolSize时，则会将多余的线程存放在队列中， 
         * 若队列已满，且最请求线程小于maximumPoolSize的情况下，则自定义的线程池会创建新的线程， 
         * 若队列已满，且最请求线程大于maximumPoolSize的情况下，则执行拒绝策略，或其他自定义方式。 
         */  
		ThreadPoolExecutor myPool = new ThreadPoolExecutor(1,
				2, 10, TimeUnit.SECONDS, queue);
		
		ThreadDemo d1 = new ThreadDemo("t1");
		ThreadDemo d2 = new ThreadDemo("t2");
		ThreadDemo d3 = new ThreadDemo("t3");
		ThreadDemo d4 = new ThreadDemo("t4");
		ThreadDemo d5 = new ThreadDemo("t5");
		myPool.execute(d1);
		myPool.execute(d2);
		myPool.execute(d3);
		myPool.execute(d4);
		myPool.execute(d5);
		myPool.shutdown();
		
		/**
		* 创建了一个自定义的线程池。
		此处我们可以把任务一个一个加入到线程池中去验证上述情况看是否正确。
		1.放入task1的时候马上执行，然后休眠5s关闭线程池。
		2.放入task1和task2的时候我们发现，此时task1先执行，然后task2等待5s执行，然后等待5s线程池调用shutdown()方法关闭。
		3.放入3个任务和4个的时候发现都是一次睡眠等待执行，关闭。
		4.放入5个的时候我们发现线程1和线程5是同时执行的。然后依次执行task2,3,4.此时我们coreSize是1队列是满的，此时会创建一个线程。因为是5个任务，队列是满的，并且这种情况maxSize还可以创建一个线程执行，所有1和5是同时打印的，然后按照顺序依次执行。
		5.放入6个任务的时候我们发现1和5执行完之后task6会抛出个异常不去执行，然后执行2.3.4.
		 */
		
	}

}
