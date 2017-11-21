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

import com.fql.constant.Constant;
import com.fql.hero.Axiu;

public class Server {

	public static ExecutorService sendData = Executors.newSingleThreadExecutor();
	public static ExecutorService receiveData = Executors.newSingleThreadExecutor();
	public static DatagramSocket server;
	public static final DatagramPacket packet = new DatagramPacket(new byte[50], 50);
	public static final DatagramPacket receivepacket = new DatagramPacket(new byte[50], 50);
	public static Map<Integer, Object> heros = new HashMap();
	public static Set<Integer> herosId;
	public static Iterator<Integer> iterator;
	public static List<Object[]> clients=new ArrayList<>();

	public Server() {
		try {
			server = new DatagramSocket(9999);
			clients.add(new Object[]{"127.0.0.1",8888});
			clients.add(new Object[]{"127.0.0.1",8889});
			ExecutorService sendData = Executors.newSingleThreadExecutor();
			sendData.execute(new Runnable() {
				public void run() {
					while (true) {
						try {
							herosId = heros.keySet();
							iterator = herosId.iterator();
							while (iterator.hasNext()) {
								int heroId = iterator.next().intValue();
								switch (heroId) {
								case 1: {
									String context = Axiu.heroId + "/" + Axiu.state + "/" + Axiu.currentImage + "/"
											+ Axiu.imageX + "/" + Axiu.imageY;
									packet.setData(context.toString().getBytes());
									for(Object[] object:clients){
										packet.setSocketAddress(new InetSocketAddress((String)object[0], (int)object[1]));
										server.send(packet);
									}
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
								Axiu axiu=(Axiu)Server.heros.get(herosId);
								int keyCode=Integer.valueOf(result[3]).intValue();
								if(result[4].equals("keyPressed")){
									if(keyCode==KeyEvent.VK_RIGHT){
										if(axiu.state==Constant.STAND){
											axiu.state=Constant.WALK;
											axiu.currentImage=0;
										}
										if(axiu.state==Constant.STAND || axiu.state==Constant.WALK){
											axiu.direction=Constant.RIGHT;
										}
									}
								}else{
									if(keyCode==KeyEvent.VK_RIGHT){
										if(axiu.state==Constant.WALK){
											axiu.state=Constant.STAND;
											axiu.currentImage=0;
										}
									}
								}
							}
							}
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
