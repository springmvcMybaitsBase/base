package com.mana.threadDeam.proandreduce;
/**
 * 生产者
 * @author user
 */
public class ProductDemo extends Thread{
	
	private StockDemo stock;
	private int needNum;
	
	public ProductDemo(){}
	
	public ProductDemo(String name,StockDemo stock,int needNum){
		super(name);
		this.stock = stock;
		this.needNum = needNum;
	}
	  
	public void run(){
		stock.addNum(needNum);
	}

}
