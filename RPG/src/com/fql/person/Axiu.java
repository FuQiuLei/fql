package com.fql.person;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.fql.config.Config;
import com.fql.ui.MainUI;

public class Axiu {
	private int life=150;
	private int attack=18;
	private int defend=6;
	private int height=102;
	private int width=69;
	private int piancha=-1;//偏差
	private int state=0;    // 0=站立      ; 1=走动   ;2=跳跃
	private int direction=0;// 0=right; 1=left;
	private String imageName="axiu/axiu0001.gif";
	
	private JLabel jLabel = new JLabel();
	
	
	public Axiu() {
	}
	
	public Axiu(JPanel jPanel) {
		jPanel.add(this.jLabel);
		jLabel.setIcon(new ImageIcon(Config.imagePath+this.imageName));
		jLabel.setBounds(50, MainUI.dibianHeight-height+piancha, width, height);
		jLabel.setVisible(true);
		MainUI.axiu=this;
	}
	
	public void walkRight(final Axiu axiu){//右走
		Config.fixedThreadPool.execute(new Runnable() {
			
			public void run() {
				if(axiu.getState()!=2){
					axiu.setState(1);
					axiu.setDirection(0);
					axiu.getjLabel().setIcon(new ImageIcon(Config.imagePath+"axiu/axiu0002.gif"));
					axiu.getjLabel().setBounds(axiu.getjLabel().getX()+3,axiu.getjLabel().getY(), axiu.getjLabel().getWidth(), axiu.getjLabel().getHeight());
					MainUI.jPanel.updateUI();
				}
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
	
	
	
}
