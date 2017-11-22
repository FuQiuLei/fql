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
	public static int state = Constant.STAND;
	public static int direction = Constant.RIGHT;

	public BaShen() {
		try {
			imageX = x - (int) stand[currentImage][1];
			imageY = y - (int) stand[currentImage][2];
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
			new Object[] { "walkRight/0012.png", 25, 116 } };

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
			new Object[] { "stand/0010.png", 25, 116 } };


}
