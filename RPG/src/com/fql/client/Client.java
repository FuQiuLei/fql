package com.fql.client;

import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;

import com.fql.constant.Constant;
import com.fql.hero.Axiu;

public class Client {
	
	public static ExecutorService receiveData;
	public static DatagramSocket client;
	public static DatagramPacket packet;
	public static String clientIp;
	public static int clientPort;
	public static String serverIp;
	public static int serverPort;
	
	public Client(){
		try {
			boolean flag=true;
			while(flag){
				try{
				client=new DatagramSocket(clientPort);
				flag=false;
				}catch(Exception e){
					clientPort++;
				}
			}
			packet=new DatagramPacket(new byte[1024], 1024);
			receiveData=Executors.newSingleThreadExecutor();
			receiveData.execute(new Runnable(){
				public void run() {
					while(true){
						try{
							client.receive(packet);
							byte[] b=packet.getData();
							String context=new String(b,0,packet.getLength());
							String[] result=context.split("/");
							switch (result[0]){
								case "1":{
									if(result[1].equals(Constant.STAND+"")){
										Axiu.image=ImageIO.read(new File(Axiu.imagePath+(String)Axiu.stand[Integer.valueOf(result[2]).intValue()][0]));
										Axiu.imageX=Integer.valueOf(result[3]).intValue();
										Axiu.imageY=Integer.valueOf(result[4]).intValue();
									}else if(result[1].equals(Constant.WALK+"")){
										Axiu.image=ImageIO.read(new File(Axiu.imagePath+(String)Axiu.walkRight[Integer.valueOf(result[2]).intValue()][0]));
										Axiu.imageX=Integer.valueOf(result[3]).intValue();
										Axiu.imageY=Integer.valueOf(result[4]).intValue();
									}
								}
							}
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
