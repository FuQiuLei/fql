package com.fql.person;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Axiu {
	
	public BufferedImage image;
	public int x=100;
	public int y=250;
	public int imageX=0;
	public int imageY=0;
	private int totalImage=12;
	private int currentImage=0;
	public static String imagePath;
	
	public Axiu(){
		try {
			this.image=ImageIO.read(new File(this.imagePath+(String)(this.walk[6][0])));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(){
		if(currentImage<totalImage-1){
			currentImage++;
		}else{
			currentImage=0;
		}
		try {
			this.image=ImageIO.read(new File(this.imagePath+(String)(this.walk[currentImage][0])));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object[][] walk={
			new Object[]{"0001.bmp",25,58},
			new Object[]{"0002.bmp",25,58},
			new Object[]{"0003.bmp",25,58},
			new Object[]{"0004.bmp",25,58},
			new Object[]{"0005.bmp",25,58},
			new Object[]{"0006.bmp",25,58},
			new Object[]{"0007.bmp",25,58},
			new Object[]{"0008.bmp",25,58},
			new Object[]{"0009.bmp",25,58},
			new Object[]{"0010.bmp",25,58},
			new Object[]{"0011.bmp",25,58},
			new Object[]{"0012.bmp",25,58}
	};

}
