package com.mana.threadDeam;

public class MainClassDemo {
	
	public static void main(String[] args) {
		ThreadDemo tdemo = new ThreadDemo();
		
		
		Thread rdemo = new Thread(new RunableDemo());
		
		tdemo.start();;
		
		rdemo.start();
	}

}
