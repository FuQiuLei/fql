package com.fql.config;

import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.fql.client.Client;
import com.fql.hero.*;
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
			BaShen.imagePath=properties.getProperty("BaShenImagePath");
			Client.heroId=Integer.valueOf(properties.getProperty("heroId")).intValue();
			Client.clientIp=properties.getProperty("client.ip");
			Client.clientPort=Integer.valueOf(properties.getProperty("client.port")).intValue();
			Client.serverPort=Integer.valueOf(properties.getProperty("server.port")).intValue();
			Client.serverIp=properties.getProperty("server.ip");
		} catch (Exception e) {
			e.printStackTrace();
			//todo   ������ʾ��
		}
	}
}
