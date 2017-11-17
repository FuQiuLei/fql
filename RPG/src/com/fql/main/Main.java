package com.fql.main;

import com.fql.config.Config;

public class Main {

	public static void main(String[] args) {
		Config.load();
		System.out.println(Config.imagePath);
	}

}
