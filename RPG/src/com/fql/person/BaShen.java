package com.fql.person;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class BaShen {
	
	public static BufferedImage image;
	public int x = 700;
	public int y = 380;
	public static int imageX = 0;
	public static int imageY = 0;
	public static int totalImage = 10;
	public int currentImage = 0;
	public int state = 0;// 0=Õ¾Á¢ ; 1=×ß¶¯ ;2=ÌøÔ¾;3¹¥»÷
	public int direction = 0; // 0=left; 1=right;
	public static String imagePath;

	public BaShen() {
		try {
			if (state == 0) {
				imageX = x - (int) stand[currentImage][1];
				imageY = y - (int) stand[currentImage][2];
			}
			this.image = ImageIO.read(new File(this.imagePath + (String) (this.stand[0][0])));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update() {
		try {
			setImageNum();
			if (state == 0) {
				this.image = ImageIO.read(new File(this.imagePath + (String) (this.stand[currentImage][0])));
			}
			if (state == 1) {
				this.image = ImageIO.read(new File(this.imagePath + (String) (this.walkRight[currentImage][0])));
			}
			if (state == 1) {
				if (direction == 0) {
					x -= 3;
					imageX -= 3;
				} else {
					x += 3;
					imageX += 3;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setImageNum() {
		if (state == 0) {
			totalImage = 10;
		} else if (state == 1) {
			totalImage = 12;
		} else if (state == 2) {
			totalImage = 12;
		}
		if (currentImage < totalImage - 1) {
			currentImage++;
		} else {
			currentImage = 0;
		}
	}

	public void rightForXy() {
		x += 3;
		if (state == 1) {
			imageX = x - (int) walkRight[currentImage][1];
			imageY = y - (int) walkRight[currentImage][2];
		}

	}

	public static Object[][] walkRight = { new Object[] { "walkRight/0001.png", 25, 116 },
			new Object[] { "walkRight/0002.png", 25, 116 }, new Object[] { "walkRight/0003.png", 25, 116 },
			new Object[] { "walkRight/0004.png", 25, 116 }, new Object[] { "walkRight/0005.png", 25, 116 },
			new Object[] { "walkRight/0006.png", 25, 116 }, new Object[] { "walkRight/0007.png", 25, 116 },
			new Object[] { "walkRight/0008.png", 25, 116 }, new Object[] { "walkRight/0009.png", 25, 116 },
			new Object[] { "walkRight/0010.png", 25, 116 }, new Object[] { "walkRight/0011.png", 25, 116 },
			new Object[] { "walkRight/0012.png", 25, 116 } };

	public static Object[][] stand = { new Object[] { "stand/0001.png", 25, 116 }, new Object[] { "stand/0002.png", 25, 116 },
			new Object[] { "stand/0003.png", 25, 116 }, new Object[] { "stand/0004.png", 25, 116 },
			new Object[] { "stand/0005.png", 25, 116 }, new Object[] { "stand/0006.png", 25, 116 },
			new Object[] { "stand/0007.png", 25, 116 }, new Object[] { "stand/0008.png", 25, 116 },
			new Object[] { "stand/0009.png", 25, 116 }, new Object[] { "stand/0010.png", 25, 116 } };

}
