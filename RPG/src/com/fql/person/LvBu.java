package com.fql.person;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.fql.config.Config;
import com.fql.ui.MainUI;

public class LvBu {
	
	private int life=200;
	private int attack=20;
	private int defend=5;
	private int height=255;
	private int width=266;
	private int piancha=35;
	private int state=0;     // 0=站立      ; 1=走动   ;2=跳跃
	private int direction=0; // 0=right; 1=left;
	private String imageName="0006.gif";
	
	private JLabel jLabel=new JLabel();
	
	public LvBu(){}
	public LvBu(JPanel jPanel){
		jPanel.add(this.jLabel);
		jLabel.setIcon(new ImageIcon(Config.imagePath+this.imageName));
		jLabel.setBounds(700, MainUI.dibianHeight-height+piancha, width, height);
		jLabel.setVisible(true);
		MainUI.lvBu=this;
	}

	public void walkLeft(final LvBu lvbu){  //左走
		Config.fixedThreadPool.execute(new Runnable(){
			public void run() {
				if(lvbu.getState()!=2){
					lvbu.setState(1);
					lvbu.setDirection(0);
					lvbu.getjLabel().setIcon(new ImageIcon(Config.imagePath+"0003.gif"));
					lvbu.getjLabel().setBounds(lvbu.getjLabel().getX()-3, lvbu.getjLabel().getY(), lvbu.getjLabel().getWidth(), lvbu.getjLabel().getHeight());
					MainUI.jPanel.updateUI();
				}
			}
		});
	}
	
	public void walkRight(final LvBu lvbu){ //右走
		Config.fixedThreadPool.execute(new Runnable(){
			public void run() {
				if(lvbu.getState()!=2){
					lvbu.setState(1);
					lvbu.setDirection(1);
					lvbu.getjLabel().setIcon(new ImageIcon(Config.imagePath+"0007.gif"));
					lvbu.getjLabel().setBounds(lvbu.getjLabel().getX()+3, lvbu.getjLabel().getY(), lvbu.getjLabel().getWidth(), lvbu.getjLabel().getHeight());
					MainUI.jPanel.updateUI();
				}
			}
		});
	}
	
	public void jump(final LvBu lvbu){ //跳跃
		Config.fixedThreadPool.execute(new Runnable(){
			public void run() {
				if(lvbu.getState()!=2){
					lvbu.setState(2);
					if(lvbu.getDirection()==0){
						lvbu.getjLabel().setIcon(new ImageIcon(Config.imagePath+"up0001.gif"));
						try {
							Thread.currentThread().sleep(900);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						lvbu.getjLabel().setIcon(new ImageIcon(Config.imagePath+"0006.gif"));
					}else{
						lvbu.getjLabel().setIcon(new ImageIcon(Config.imagePath+"up0002.gif"));
						try {
							Thread.currentThread().sleep(900);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						lvbu.getjLabel().setIcon(new ImageIcon(Config.imagePath+"0004.gif"));
					}
					lvbu.setState(0);
				}
				MainUI.jPanel.updateUI();
			}
		});
	}
	
	public void walk(final LvBu lvbu){
		Config.fixedThreadPool.execute(new Runnable(){
			public void run() {
				if(lvbu.getDirection()==0){
					lvbu.getjLabel().setIcon(new ImageIcon(Config.imagePath+"0006.gif"));
				}else{
					lvbu.getjLabel().setIcon(new ImageIcon(Config.imagePath+"0004.gif"));
				}
				lvbu.setState(0);
				MainUI.jPanel.updateUI();
			}
		});
	}
	

	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefend() {
		return defend;
	}
	public void setDefend(int defend) {
		this.defend = defend;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getPiancha() {
		return piancha;
	}
	public void setPiancha(int piancha) {
		this.piancha = piancha;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public JLabel getjLabel() {
		return jLabel;
	}
	public void setjLabel(JLabel jLabel) {
		this.jLabel = jLabel;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
}
