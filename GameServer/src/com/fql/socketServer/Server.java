package com.fql.socketServer;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fql.constant.Constant;
import com.fql.hero.Axiu;
import com.fql.hero.BaShen;

public class Server {

	public static ExecutorService sendData = Executors.newSingleThreadExecutor();
	public static ExecutorService receiveData = Executors.newSingleThreadExecutor();
	public static ExecutorService updateHero = Executors.newSingleThreadExecutor();
	public static DatagramSocket server;
	public static final DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
	public static final DatagramPacket receivepacket = new DatagramPacket(new byte[1024], 1024);
	public static Map<Integer, Object> heros = new HashMap();
	public static Set<Integer> herosId;
	public static Iterator<Integer> iterator;
	public static List<Object[]> clients=new ArrayList<>();

	public Server() {
		try {
			server = new DatagramSocket(9999);
			clients.add(new Object[]{"127.0.0.1",8888});
			clients.add(new Object[]{"127.0.0.1",8889});

			//给客户端发送消息
			sendData.execute(new Runnable() {
				public void run() {
					while (true) {
						try {
							herosId = heros.keySet();
							iterator = herosId.iterator();
							JSONArray array=new JSONArray();
							while (iterator.hasNext()) {
								int heroId = iterator.next().intValue();
								switch (heroId) {
									case 1: {
										JSONObject object=new JSONObject();
										object.put("heroId", Axiu.heroId);
										object.put("currentImagePath", Axiu.currentImagePath);
										object.put("imageX", Axiu.imageX);
										object.put("imageY", Axiu.imageY);
										array.add(object);
										continue;
									}
									case 2: {
										JSONObject object=new JSONObject();
										object.put("heroId", BaShen.heroId);
										object.put("currentImagePath", BaShen.currentImagePath);
										object.put("imageX", BaShen.imageX);
										object.put("imageY", BaShen.imageY);
										array.add(object);
										continue;
									}
								}
							}
							packet.setData(array.toJSONString().getBytes());
							for(Object[] object:clients){
								packet.setSocketAddress(new InetSocketAddress((String)object[0], (int)object[1]));
								server.send(packet);
							}
							Thread.currentThread().sleep(50);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			});

			//接受客户端发送的按键信息
			receiveData.execute(new Runnable(){
				public void run() {
					while(true){
						try {
							server.receive(receivepacket);
							byte[] b=receivepacket.getData();
							String context=new String(b,0,receivepacket.getLength());
							String[] result=context.split("/");
							int heroId=Integer.valueOf(result[0]).intValue();
							switch(heroId){
								case 1:{
									int keyCode=Integer.valueOf(result[3]).intValue();
									if(result[4].equals("keyPressed")){
										Axiu.updateForPressed(keyCode);
									}else{
										Axiu.updateForReleased(keyCode);
									}
									continue;
								}
								case 2:{
									int keyCode=Integer.valueOf(result[3]).intValue();
									if(result[4].equals("keyPressed")){
										BaShen.updateForPressed(keyCode);
									}else{
										BaShen.updateForReleased(keyCode);
									}
									continue;
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			});

			//实时更新人物状态
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
										Axiu.updateHero();
										continue;
									}
									case 2: {
										BaShen.updateHero();
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
