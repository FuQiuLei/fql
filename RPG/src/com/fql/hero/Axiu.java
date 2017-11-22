package com.fql.hero;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Axiu {
	
	public static int x=100;
	public static int y=380;
	public static int imageX=0;
	public static int imageY=0;
	public static BufferedImage image;
	public static int currentImage=0;
	public static int totalImage=0;
	public static String imagePath;
	
	public Axiu(){
		try {
			imageX = x - (int) stand[currentImage][1];
			imageY = y - (int) stand[currentImage][2];
			Axiu.image=ImageIO.read(new File(imagePath+(String)Axiu.stand[0][0]));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Object[][] walkRight = { 
			new Object[] { "walkRight/0001.png", 25, 116 },
			new Object[] { "walkRight/0002.png", 25, 116 }, 
			new Object[] { "walkRight/0003.png", 25, 116 },
			new Object[] { "walkRight/0004.png", 25, 116 }, 
			new Object[] { "walkRight/0005.png", 25, 116 },
			new Object[] { "walkRight/0006.png", 25, 116 }, 
			new Object[] { "walkRight/0007.png", 25, 116 },
			new Object[] { "walkRight/0008.png", 25, 116 }, 
			new Object[] { "walkRight/0009.png", 25, 116 },
			new Object[] { "walkRight/0010.png", 25, 116 }, 
			new Object[] { "walkRight/0011.png", 25, 116 },
			new Object[] { "walkRight/0012.png", 25, 116 } 
	};

	public static Object[][] stand = { 
			new Object[] { "stand/0001.png", 25, 116 }, 
			new Object[] { "stand/0002.png", 25, 116 },
			new Object[] { "stand/0003.png", 25, 116 }, 
			new Object[] { "stand/0004.png", 25, 116 },
			new Object[] { "stand/0005.png", 25, 116 }, 
			new Object[] { "stand/0006.png", 25, 116 },
			new Object[] { "stand/0007.png", 25, 116 }, 
			new Object[] { "stand/0008.png", 25, 116 },
			new Object[] { "stand/0009.png", 25, 116 }, 
			new Object[] { "stand/0010.png", 25, 116 } 
	};
	
	public static Object[][] wuyue={
			new Object[] { "attack-wuyue/0001.png", 57, 119 }, 
			new Object[] { "attack-wuyue/0002.png", 57, 119 },
			new Object[] { "attack-wuyue/0003.png", 57, 119 },
			new Object[] { "attack-wuyue/0004.png", 57, 119 },
			new Object[] { "attack-wuyue/0005.png", 57, 119 },
			new Object[] { "attack-wuyue/0006.png", 57, 119 },
			new Object[] { "attack-wuyue/0007.png", 57, 119 },
			new Object[] { "attack-wuyue/0008.png", 57, 119 },
			new Object[] { "attack-wuyue/0009.png", 57, 119 },
			new Object[] { "attack-wuyue/0010.png", 57, 119 },
			new Object[] { "attack-wuyue/0011.png", 57, 119 },
			new Object[] { "attack-wuyue/0012.png", 57, 119 },
			new Object[] { "attack-wuyue/0013.png", 57, 119 },
			new Object[] { "attack-wuyue/0014.png", 57, 119 },
			new Object[] { "attack-wuyue/0015.png", 57, 119 },
			new Object[] { "attack-wuyue/0016.png", 57, 119 },
			new Object[] { "attack-wuyue/0017.png", 57, 119 },
			new Object[] { "attack-wuyue/0018.png", 57, 119 },
			new Object[] { "attack-wuyue/0019.png", 57, 119 },
			new Object[] { "attack-wuyue/0020.png", 57, 119 },
			new Object[] { "attack-wuyue/0021.png", 57, 119 },
			new Object[] { "attack-wuyue/0022.png", 57, 119 },
			new Object[] { "attack-wuyue/0023.png", 57, 119 },
			new Object[] { "attack-wuyue/0024.png", 57, 119 },
			new Object[] { "attack-wuyue/0025.png", 57, 119 },
			new Object[] { "attack-wuyue/0026.png", 57, 119 },
			new Object[] { "attack-wuyue/0027.png", 57, 119 }
	};

}
