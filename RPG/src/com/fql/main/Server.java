package com.fql.main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	public static void main(String[] args) {
		try {
			final DatagramSocket server=new DatagramSocket(9999);
			final DatagramPacket packet=new DatagramPacket(new byte[1024], 1024);
			ExecutorService sendData=Executors.newSingleThreadExecutor();
			sendData.execute(new Runnable(){
				public void run() {
					for(int i=0;;i++){
						try{
							packet.setData((i+"").getBytes());
							packet.setSocketAddress(new InetSocketAddress("127.0.0.1", 8888));
							server.send(packet);
							if(i>=9){
								i=0;
							}
							Thread.currentThread().sleep(100);
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
