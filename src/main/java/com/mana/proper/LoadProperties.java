package com.mana.proper;

import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	
	public Properties getPro(String fileName) {
		Properties pro = new Properties();
		try {
			pro.load(this.getClass().getResourceAsStream("testpro.properties"));
			return pro;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
