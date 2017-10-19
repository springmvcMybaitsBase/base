package com.mana.threadDeam.proandreduce;

public class MainDemo {
	
	public static void main(String[] args) {
		StockDemo stock = new StockDemo(100, 30);
		ReduceDemo r1 = new ReduceDemo("r1",stock,30);
		ReduceDemo r2 = new ReduceDemo("r2",stock,40);
		ReduceDemo r3 = new ReduceDemo("r3",stock,50);
		ReduceDemo r4 = new ReduceDemo("r4",stock,60);
		
		ProductDemo p1 = new ProductDemo("p1",stock,50);
		ProductDemo p2 = new ProductDemo("p2",stock,30);
		ProductDemo p3 = new ProductDemo("p3",stock,20);
		ProductDemo p4 = new ProductDemo("p4",stock,10);
		ProductDemo p5 = new ProductDemo("p5",stock,60);
		ProductDemo p6 = new ProductDemo("p6",stock,50);
		
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		p6.start();
		
	}
}
