package com.fql.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {
	public static String imagePath;
	
	public static void load(){
		Properties properties=new Properties();
		try {
			properties.load(new FileReader(Config.class.getResource("config.properties").getFile()));
			imagePath=properties.getProperty("imagePath");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
