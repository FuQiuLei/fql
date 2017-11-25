package com.fql.main;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;
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
		jFrame.setBounds(800, 200, 300, 100);
		jFrame.setVisible(true);
		jFrame.setResizable(false);
		jFrame.setTitle("憨巴日-服务器");
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
	}
}
