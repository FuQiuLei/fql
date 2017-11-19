package com.fql.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.fql.config.Config;

public class MyPanel extends JPanel {

	
	public static MyPanel myPanel;
	public static int backgrounds=8;
	public static int currentBackground=0;
	public static String backgroundImagePath;
	private static BufferedImage currentBackgroundImage;
	private static Graphics g;

	public MyPanel() {
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		myPanel = this;
		g=getGraphics();
	}

	public void updateHero(){
		Config.updateHero.execute(new Runnable(){
			public void run() {
				while(true){
					try {
						for(int i=0;i<MyFrame.list.size();i++){
							MyFrame.list.get(i).update();
						}
						Thread.currentThread().sleep(100);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	@Override
	public void paint(final Graphics g) {
		Config.updateUI.execute(new Runnable(){
			public void run() {
				while(true){
					try {
						MyPanel.currentBackgroundImage=ImageIO.read(new File(backgroundImagePath+(String)background[currentBackground][0]));
						if(MyPanel.currentBackground<7){
							MyPanel.currentBackground++;
						}else{
							MyPanel.currentBackground=0;
						}
						g.drawImage(MyPanel.currentBackgroundImage, 0, 0,MyPanel.myPanel);
						for(int i=0;i<MyFrame.list.size();i++){
							BufferedImage hero=MyFrame.list.get(i).image;
							g.drawImage(hero, MyFrame.list.get(i).x, MyFrame.list.get(i).y,MyPanel.myPanel);
						}
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
