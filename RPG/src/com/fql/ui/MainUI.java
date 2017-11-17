package com.fql.ui;

import javax.swing.*;
import java.awt.*;

public class MainUI {
    public static JFrame jFrame=new JFrame();
    public static JPanel jPanel=new JPanel();

    public static void paintUI(){
        jFrame.setBounds(100,100,500,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setBackground(Color.BLACK);
        jFrame.add(jPanel);
        jPanel.setVisible(true);
        jPanel.setBackground(Color.BLACK);
        jPanel.setLayout(null);
        JLabel label=new JLabel();
        label.setBounds(0,0,100,100);
        label.setBackground(Color.BLUE);
        label.setVisible(true);
        label.setText("哈哈分解诶过hire天宫额");
        jPanel.add(label);
        JButton jButton=new JButton();
        jButton.setBounds(0,0,100,100);
        jButton.setVisible(true);
        jButton.setText("按钮");
//        label.setLocation(100,200);
        jPanel.add(jButton);
        jPanel.updateUI();
    }
}
