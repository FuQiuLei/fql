package com.fql.ui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.fql.client.Client;
import com.fql.hero.Axiu;

public class MyFrame extends JFrame{
	
	public static List<Axiu> list=new ArrayList<>();
	public static Axiu axiu=new Axiu();;
	public static MyPanel myPanel=new MyPanel();
	public static DatagramPacket pocket=new DatagramPacket(new byte[50], 50);
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
		Client client=new Client();
		addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {   
				if(e.getKeyCode()==KeyEvent.VK_RIGHT){
					pocket.setData(("1/127.0.0.1/8888/"+KeyEvent.VK_RIGHT+"/keyReleased").getBytes());
					pocket.setSocketAddress(new InetSocketAddress("127.0.0.1", 9999));
					try {
						Client.client.send(pocket);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_RIGHT){
					pocket.setData(("1/127.0.0.1/8888/"+KeyEvent.VK_RIGHT+"/keyPressed").getBytes());
					pocket.setSocketAddress(new InetSocketAddress("127.0.0.1", 9999));
					try {
						Client.client.send(pocket);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
	}

}
