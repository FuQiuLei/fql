package com.fql.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.prism.paint.Color;

public class Config {
	public static String imagePath;
	public static ExecutorService fixedThreadPool;

	public static void load() {
		Properties properties = new Properties();
		try {
			properties.load(new FileReader(Config.class.getResource("config.properties").getFile()));
			imagePath = properties.getProperty("imagePath");
			int coreThreadSize=Integer.valueOf(properties.getProperty("coreThreadSize")).intValue();
			// 创建线程池
			fixedThreadPool = Executors.newFixedThreadPool(coreThreadSize);
//			for (int i = 0; i < 10; i++) {
//				final int index = i;
//				fixedThreadPool.execute(new Runnable() {
//					public void run() {
//						try {
//							System.out.println(index);
//							System.out.println(Thread.currentThread().getId());
//							Thread.sleep(2000);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//					}
//				});
//			}
		} catch (Exception e) {
			e.printStackTrace();
			//todo   创建提示框
		}
	}
}
