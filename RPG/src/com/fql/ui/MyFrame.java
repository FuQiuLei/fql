package com.fql.ui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.fql.person.Axiu;

public class MyFrame extends JFrame{
	
	public static List<Axiu> list=new ArrayList<>();
	
	public MyFrame(){
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100,100,1000,390);
		this.setVisible(true);
		this.setBackground(Color.BLACK);
		this.setLayout(null);
		Axiu axiu=new Axiu();
		list.add(axiu);
		MyPanel myPanel=new MyPanel();
		this.add(myPanel);
		myPanel.paint(getGraphics());
		myPanel.updateHero();
	}

}
