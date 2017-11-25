package com.fql.main;

import com.fql.config.Config;
import com.fql.ui.MyFrame;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		System.out.println("客户端");
		Config.load();
		MyFrame myFram=new MyFrame();
	}
}
