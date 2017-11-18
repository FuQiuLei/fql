package com.fql.main;

import com.fql.config.Config;
import com.fql.ui.MainUI;

public class Main {

	public static void main(String[] args) {
		Config.load();
		System.out.println(Config.imagePath);
		MainUI.paintUI();
	}
}
