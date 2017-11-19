package com.fql.ui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.fql.person.Axiu;

public class MyFrame extends JFrame{
	
	public static List<Axiu> list=new ArrayList<>();
	public static Axiu axiu=new Axiu();;
	public static MyPanel myPanel=new MyPanel();
	public MyFrame(){
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100,100,1000,390);
		this.setVisible(true);
		this.setBackground(Color.BLACK);
		this.setLayout(null);
		list.add(axiu);
		this.add(myPanel);
		myPanel.paint(getGraphics());
		myPanel.updateHero();
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				axiu.state=0;
				Axiu.totalImage=10;
				myPanel.updateHero();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_RIGHT){
					axiu.state=1;
					axiu.direction=0;
				}
				axiu.x+=2	;
				if(axiu.state==1){
					axiu.imageX=axiu.x-(int)axiu.walkRight[axiu.currentImage][1];
					axiu.imageY=axiu.y-(int)axiu.walkRight[axiu.currentImage][2];
				}
				myPanel.updateHero();
			}
		});
	}

}
