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
			this.image=ImageIO.read(new File(this.imagePath+(String)(this.walkRight[6][0])));
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
			this.image=ImageIO.read(new File(this.imagePath+(String)(this.walkRight[currentImage][0])));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object[][] walkRight={
			new Object[]{"walkRight/0001.png",25,58},
			new Object[]{"walkRight/0002.png",25,58},
			new Object[]{"walkRight/0003.png",25,58},
			new Object[]{"walkRight/0004.png",25,58},
			new Object[]{"walkRight/0005.png",25,58},
			new Object[]{"walkRight/0006.png",25,58},
			new Object[]{"walkRight/0007.png",25,58},
			new Object[]{"walkRight/0008.png",25,58},
			new Object[]{"walkRight/0009.png",25,58},
			new Object[]{"walkRight/0010.png",25,58},
			new Object[]{"walkRight/0011.png",25,58},
			new Object[]{"walkRight/0012.png",25,58}
	};

}
