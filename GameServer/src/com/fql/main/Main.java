package com.fql.main;

import java.awt.Color;
import java.awt.Font;
import java.net.InetSocketAddress;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.fql.constant.Constant;
import com.fql.hero.Axiu;
import com.fql.hero.BaShen;
import com.fql.socketServer.Server;

public class Main {
	public static void main(String[] args) {
		Server server = new Server();
		Server.heros.put(1, new Axiu());
		Server.heros.put(2, new BaShen());
		System.out.println("服务器");
		JFrame jFrame=new JFrame();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setBounds(800, 200, 100, 100);
		jFrame.setVisible(true);
		jFrame.setResizable(false);
		JPanel jPanel=new JPanel();
		jPanel.setLayout(null);
		jPanel.setVisible(true);
		JLabel jLabel=new JLabel();
		jLabel.setText("服务器");
		jLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel.setFont(new Font(null, 0, 30));
		jLabel.setBounds(0, 0, 150, 50);
		jLabel.setOpaque(true);
		jLabel.setBackground(Color.GREEN);
		jFrame.add(jPanel);
		jPanel.add(jLabel);
		ExecutorService updateHero = Executors.newSingleThreadExecutor();
		updateHero.execute(new Runnable() {
			public void run() {
				while (true) {
					try {
						Set<Integer> herosId = Server.heros.keySet();
						Iterator<Integer> iterator = herosId.iterator();
						while (iterator.hasNext()) {
							int heroId = iterator.next().intValue();
							switch (heroId) {
								case 1: {
									if (Axiu.state == Constant.STAND) {
										if (Axiu.currentImage >= 9) {
											Axiu.currentImage = 0;
										}else{
											Axiu.currentImage++;
										}
										Axiu.setImage();
									}else if(Axiu.state==Constant.WALK){
										if (Axiu.currentImage >= 11) {
											Axiu.currentImage = 0;
										}else{
											Axiu.currentImage++;
										}
										Axiu.x+=3;
										Axiu.setImage();
									}else if(Axiu.state==Constant.ATTACK){
										if (Axiu.currentImage >= 25) {
											Axiu.currentImage = 0;
											if(Axiu.nextState!=Axiu.state){
												Axiu.state=Axiu.nextState;
											}
										}else{
											Axiu.currentImage++;
										}
										Axiu.setImage();
									}
									continue;
								}
								case 2: {
									if (BaShen.state == Constant.STAND) {
										if (BaShen.currentImage >= 9) {
											BaShen.currentImage = 0;
										}else{
											BaShen.currentImage++;
										}
										BaShen.imageX = BaShen.x - (int) BaShen.stand[BaShen.currentImage][1];
										BaShen.imageY = BaShen.y - (int) BaShen.stand[BaShen.currentImage][2];
									}else if(BaShen.state==Constant.WALK){
										if (BaShen.currentImage >= 11) {
											BaShen.currentImage = 0;
										}else{
											BaShen.currentImage++;
										}
										BaShen.x-=3;
										BaShen.imageX = BaShen.x - (int) BaShen.walkRight[BaShen.currentImage][1];
										BaShen.imageY = BaShen.y - (int) BaShen.walkRight[BaShen.currentImage][2];
									}
									continue;
								}
							}
						}
						Thread.currentThread().sleep(50);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
}
