package com.fql.main;

import java.net.InetSocketAddress;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.fql.constant.Constant;
import com.fql.hero.Axiu;
import com.fql.hero.BaShen;
import com.fql.socketServer.Server;

public class Main {
	public static void main(String[] args) {
		Server server = new Server();
		Server.heros.put(1, new Axiu());
		Server.heros.put(2, new BaShen());
		ExecutorService updateHero = Executors.newSingleThreadExecutor();
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
								if (Axiu.state == Constant.STAND) {
									if (Axiu.currentImage >= 9) {
										Axiu.currentImage = 0;
									}else{
										Axiu.currentImage++;
									}
									Axiu.imageX = Axiu.x - (int) Axiu.stand[Axiu.currentImage][1];
									Axiu.imageY = Axiu.y - (int) Axiu.stand[Axiu.currentImage][2];
								}else if(Axiu.state==Constant.WALK){
									if (Axiu.currentImage >= 11) {
										Axiu.currentImage = 0;
									}else{
										Axiu.currentImage++;
									}
									Axiu.x+=3;
									Axiu.imageX = Axiu.x - (int) Axiu.walkRight[Axiu.currentImage][1];
									Axiu.imageY = Axiu.y - (int) Axiu.walkRight[Axiu.currentImage][2];
								}
								continue;
							}
							case 2: {
								if (BaShen.state == Constant.STAND) {
									if (BaShen.currentImage >= 9) {
										BaShen.currentImage = 0;
									}else{
										BaShen.currentImage++;
									}
									BaShen.imageX = BaShen.x - (int) BaShen.stand[BaShen.currentImage][1];
									BaShen.imageY = BaShen.y - (int) BaShen.stand[BaShen.currentImage][2];
								}else if(BaShen.state==Constant.WALK){
									if (BaShen.currentImage >= 11) {
										BaShen.currentImage = 0;
									}else{
										BaShen.currentImage++;
									}
									BaShen.x-=3;
									BaShen.imageX = BaShen.x - (int) BaShen.walkRight[BaShen.currentImage][1];
									BaShen.imageY = BaShen.y - (int) BaShen.walkRight[BaShen.currentImage][2];
								}
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
	}
}
