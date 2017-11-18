package com.fql.ui;

import javax.swing.*;

import com.fql.config.Config;
import com.fql.person.LvBu;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainUI {
	public static JFrame jFrame = new JFrame();
	public static JPanel jPanel = new JPanel();
	public static int frameWidth = 1000;
	public static int frameHeight = 600;
	public static int dibianHeight = frameHeight - 100;
	public static LvBu lvBu;

	public static void paintUI() {
		jFrame.setBounds(100, 100, frameWidth, frameHeight);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
		jFrame.setBackground(Color.WHITE);
		jFrame.add(jPanel);
		jPanel.setVisible(true);
		jPanel.setBackground(Color.WHITE);
		jPanel.setLayout(null);
		JLabel dibian = new JLabel();
		dibian.setOpaque(true);
		dibian.setBounds(0, dibianHeight, frameWidth, 50);
		dibian.setVisible(true);
		dibian.setBackground(Color.BLACK);
		dibian.setIcon(new ImageIcon(Config.imagePath + "dibian.bmp"));
		JButton jButton = new JButton();
		jPanel.add(dibian);

		addPerson();

		addKeyEvent();
		jPanel.updateUI();
	}

	public static void addPerson() {
		LvBu lvBu = new LvBu(jPanel);
	}

	public static void addKeyEvent() {
		jFrame.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
				if (lvBu.getState() == 1) {
					if (lvBu.getDirection() == 1) {
						lvBu.getjLabel().setIcon(new ImageIcon(Config.imagePath + "0004.gif"));
					} else if (lvBu.getDirection() == 0) {
						lvBu.getjLabel().setIcon(new ImageIcon(Config.imagePath + "0006.gif"));
					}
					lvBu.setState(0);
				}
				jPanel.updateUI();
			}

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					lvBu.walkLeft(lvBu);
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					lvBu.walkRight(lvBu);
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					lvBu.jump(lvBu);
				}
				jPanel.updateUI();
			}
		});
	}

}
