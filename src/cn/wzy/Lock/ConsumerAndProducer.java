package cn.wzy.Lock;

import java.util.Random;

public class ConsumerAndProducer {

	static String[] food = new String[5];

	static String take() throws InterruptedException {
		synchronized (food) {
			while (true) {
				for (int i = 0; i < 5; i++) {
					if (food[i] != null) {
						String tmp = food[0];
						food[0] = null;
						food.notifyAll();
						System.out.println(Thread.currentThread().getId() + " 获得了 " + i + " 的数据");
						return tmp;
					}
				}
				food.wait();
			}
		}
	}

	static void put(String data) throws InterruptedException {
		synchronized (food) {
			while (true) {
				for (int i = 0; i < 5; i++) {
					if (food[i] == null) {
						food[i] = data;
						food.notifyAll();
						System.out.println(Thread.currentThread().getId() + " 生产了 " + i + " 的数据");
						return;
					}
				}
				food.wait();
			}
		}
	}

	public static void main(String[] args) {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 1) {
				new Thread(()->{
					try {
						Thread.sleep(1000);
						take();
					} catch (InterruptedException e) {
						e.printStackTrace();
						Thread.interrupted();
					}
				}).start();
			} else {
				new Thread(()->{
					try {
						put(random.nextLong() + "");
					} catch (InterruptedException e) {
						e.printStackTrace();
						Thread.interrupted();
					}
				}).start();
			}
		}
	}
}
