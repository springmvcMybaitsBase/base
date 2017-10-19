package com.mana.threadDeam.proandreduce;
/**
 * 消费者
 * @author user
 */
public class ReduceDemo extends Thread{
	
	private StockDemo stock;
	private int needNum;
	
	public ReduceDemo(){}
	
	public ReduceDemo(String name,StockDemo stock,int needNum){
		super(name);
		this.stock = stock;
		this.needNum = needNum;
	}
	
	public void run(){
		stock.reduceNum(needNum);
	}
}
