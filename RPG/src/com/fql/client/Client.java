package com.fql.client;

import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fql.constant.Constant;
import com.fql.hero.*;

public class Client {

	public static ExecutorService receiveData;
	public static DatagramSocket client;
	public static DatagramPacket packet;
	public static int heroId;
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
//							System.out.println(context);
							JSONArray array=JSONArray.parseArray(context);
							for(int i=0;i<array.size();i++){
								JSONObject object=(JSONObject)array.get(i);
								switch (object.getIntValue("heroId")){
									case 1:{
										Axiu.image=ImageIO.read(new File(Axiu.imagePath+object.getString("currentImagePath")));
										Axiu.imageX=object.getIntValue("imageX");
										Axiu.imageY=object.getIntValue("imageY");
										continue;
									}
									case 2:{
										BaShen.image=ImageIO.read(new File(BaShen.imagePath+object.getString("currentImagePath")));
										BaShen.imageX=object.getIntValue("imageX");
										BaShen.imageY=object.getIntValue("imageY");
										continue;
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
