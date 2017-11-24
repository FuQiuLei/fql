package com.fql.hero;

import com.fql.constant.Constant;

public class BaShen {

	public static int heroId = 2;
	public static String ip = "127.0.0.1";
	public static int port = 8888;
	public static int x = 700;
	public static int y = 380;
	public static int imageX = 0;
	public static int imageY = 0;
	public static int currentImage = 0;
	public static String currentImagePath="";
	public static int state = Constant.STAND;
	public static int direction = Constant.RIGHT;

	public BaShen() {
		try {
			imageX = x - (int) stand[currentImage][1];
			imageY = y - (int) stand[currentImage][2];
			currentImagePath=(String)stand[currentImage][0];
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setImage(){
		if(state==Constant.STAND){
			imageX = x - (int) stand[currentImage][1];
			imageY = y - (int) stand[currentImage][2];
			currentImagePath=(String)stand[currentImage][0];
		}else if(state==Constant.WALK){
			imageX = x - (int) walkRight[currentImage][1];
			imageY = y - (int) walkRight[currentImage][2];
			currentImagePath=(String)walkRight[currentImage][0];
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
			new Object[] { "walkRight/0012.png", 25, 116 } };

	public static Object[][] stand = {
			new Object[] { "stand/0001.png", 25, 104 },
			new Object[] { "stand/0002.png", 25, 104 },
			new Object[] { "stand/0003.png", 25, 104 },
			new Object[] { "stand/0004.png", 25, 104 },
			new Object[] { "stand/0005.png", 25, 104 },
			new Object[] { "stand/0006.png", 25, 104 },
			new Object[] { "stand/0007.png", 25, 104 },
			new Object[] { "stand/0008.png", 25, 104 },
			new Object[] { "stand/0009.png", 25, 104 },
			new Object[] { "stand/0010.png", 25, 104 } };

	public static Object[][] wuyue={
			new Object[] { "attack-wuyue/0001.png", 27, 118 },
			new Object[] { "attack-wuyue/0002.png", 27, 118 },
			new Object[] { "attack-wuyue/0003.png", 27, 118 },
			new Object[] { "attack-wuyue/0004.png", 27, 118 },
			new Object[] { "attack-wuyue/0005.png", 27, 118 },
			new Object[] { "attack-wuyue/0006.png", 27, 118 },
			new Object[] { "attack-wuyue/0007.png", 27, 118 },
			new Object[] { "attack-wuyue/0008.png", 27, 118 },
			new Object[] { "attack-wuyue/0009.png", 27, 118 },
			new Object[] { "attack-wuyue/0010.png", 27, 118 },
			new Object[] { "attack-wuyue/0011.png", 27, 118 },
			new Object[] { "attack-wuyue/0012.png", 27, 118 },
			new Object[] { "attack-wuyue/0013.png", 27, 118 },
			new Object[] { "attack-wuyue/0014.png", 27, 118 },
			new Object[] { "attack-wuyue/0015.png", 27, 118 },
			new Object[] { "attack-wuyue/0016.png", 27, 118 },
			new Object[] { "attack-wuyue/0017.png", 27, 118 },
			new Object[] { "attack-wuyue/0018.png", 27, 118 },
			new Object[] { "attack-wuyue/0019.png", 27, 118 },
			new Object[] { "attack-wuyue/0020.png", 27, 118 },
			new Object[] { "attack-wuyue/0021.png", 27, 118 },
			new Object[] { "attack-wuyue/0022.png", 27, 118 },
			new Object[] { "attack-wuyue/0023.png", 27, 118 },
			new Object[] { "attack-wuyue/0027.png", 27, 118 },
			new Object[] { "attack-wuyue/0025.png", 27, 118 },
			new Object[] { "attack-wuyue/0026.png", 27, 118 },
			new Object[] { "attack-wuyue/0027.png", 27, 118 }
	};


}
