package com.fql.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.fql.config.Config;
import com.fql.hero.*;

public class MyPanel extends JPanel {


	public static MyPanel myPanel;
	public static int backgrounds=8;
	public static int currentBackground=0;
	public static String backgroundImagePath;
	private static BufferedImage currentBackgroundImage;
	private static Graphics2D g2;

	public MyPanel() {
		myPanel = this;
		currentBackgroundImage=new BufferedImage(1000,390,BufferedImage.TYPE_INT_RGB);
		g2=currentBackgroundImage.createGraphics();
	}

	@Override
	public void paint(final Graphics g) {
		Config.updateUI.execute(new Runnable(){
			public void run() {
				while(true){
					try {
						//绘制背景图片
						BufferedImage image=ImageIO.read(new File(backgroundImagePath+(String)background[currentBackground][0]));
						if(MyPanel.currentBackground<7){
							MyPanel.currentBackground++;
						}else{
							MyPanel.currentBackground=0;
						}
						g2.drawImage(image, 0, 0,MyPanel.myPanel);
						//绘制英雄图片
						Iterator<Integer> iterator=MyFrame.heros.keySet().iterator();
						while(iterator.hasNext()){
							int heroId=iterator.next().intValue();
							switch(heroId){
								case 1:{
									BufferedImage hero=Axiu.image;
									g2.drawImage(hero, Axiu.imageX, Axiu.imageY,MyPanel.myPanel);
								}
								case 2:{
									BufferedImage hero=BaShen.image;
									g2.drawImage(hero, BaShen.imageX, BaShen.imageY,MyPanel.myPanel);
								}
							}
						}
						g.drawImage(currentBackgroundImage, 0, 0,MyPanel.myPanel);
						MyPanel.myPanel.updateUI();
						Thread.currentThread().sleep(100);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	public Object[][] background={
			new Object[]{"background0001.bmp",0,0},
			new Object[]{"background0002.bmp",0,0},
			new Object[]{"background0003.bmp",0,0},
			new Object[]{"background0004.bmp",0,0},
			new Object[]{"background0005.bmp",0,0},
			new Object[]{"background0006.bmp",0,0},
			new Object[]{"background0007.bmp",0,0},
			new Object[]{"background0008.bmp",0,0}
	};

}
