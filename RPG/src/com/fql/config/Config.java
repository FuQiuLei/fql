package com.fql.config;

import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.fql.hero.Axiu;
import com.fql.ui.MyPanel;

public class Config {

	public static ExecutorService updateHero=Executors.newSingleThreadExecutor();
	public static ExecutorService updateUI=Executors.newSingleThreadExecutor();

	public static void load() {
		Properties properties = new Properties();
		try {
			properties.load(new FileReader(Config.class.getResource("config.properties").getFile()));
			MyPanel.backgroundImagePath=properties.getProperty("backgroundImagePath");
			Axiu.imagePath=properties.getProperty("AxiuImagePath");
		} catch (Exception e) {
			e.printStackTrace();
			//todo   创建提示框
		}
	}
}
