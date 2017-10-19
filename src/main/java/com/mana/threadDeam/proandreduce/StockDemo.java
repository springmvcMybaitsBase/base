package com.mana.threadDeam.proandreduce;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;

/**
 * 库存
 * @author user
 */
public class StockDemo {
	
	private int maxNum;//库存最大数量
	private int num ; 
	
	public StockDemo(int maxNum,int num){
		this.maxNum = maxNum;
		this.num = num;
	}
	
	public synchronized void addNum(int needNum){
		try {
			while(num+needNum > maxNum){
				wait();
			}
			num += needNum;
			System.out.println("当前库存为："+num);
			notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void reduceNum(int needNum){
		try {
			while(num-needNum < 0){
				wait();
			}
			num -= needNum;
			System.out.println("当前库存为："+num);
			notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int getNum(){
		return num;
	}

}
