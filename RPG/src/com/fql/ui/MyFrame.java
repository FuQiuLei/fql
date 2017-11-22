package com.fql.ui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import com.fql.client.Client;
import com.fql.hero.*;

public class MyFrame extends JFrame{
	
	public static Map<Integer,Object> heros=new HashMap<>();
	public static Axiu axiu=new Axiu();
	public static BaShen baShen=new BaShen();
	public static MyPanel myPanel=new MyPanel();
	public static DatagramPacket pocket=new DatagramPacket(new byte[50], 50);
	public MyFrame(){
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100,100,1000,390);
		this.setVisible(true);
		this.setBackground(Color.BLACK);
		this.setLayout(null);
		heros.put(1,axiu);
		heros.put(2,baShen);
		this.add(myPanel);
		myPanel.paint(getGraphics());
		Client client=new Client();
		addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {   
				if(e.getKeyCode()==KeyEvent.VK_RIGHT){
					pocket.setData((Client.heroId+"/"+Client.clientIp+"/"+Client.clientPort+"/"+KeyEvent.VK_RIGHT+"/keyReleased").getBytes());
					pocket.setSocketAddress(new InetSocketAddress(Client.serverIp, Client.serverPort));
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
					pocket.setData((Client.heroId+"/"+Client.clientIp+"/"+Client.clientPort+"/"+KeyEvent.VK_RIGHT+"/keyPressed").getBytes());
					pocket.setSocketAddress(new InetSocketAddress(Client.serverIp, Client.serverPort));
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
