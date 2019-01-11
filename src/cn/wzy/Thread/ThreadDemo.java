package cn.wzy.Thread;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadDemo {
	public static void main(String[] args) {
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
		for (int i = 0; i < 30; i++) {
			final int index = i;
			if (i == 20) {
				executor.scheduleAtFixedRate(new Runnable() {
					@Override
					public void run() {
						System.out.println("hello world!");
					}
				},0,2, TimeUnit.SECONDS);
			} else {
				executor.execute(()->{
					System.out.println("index: " + index);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				});
			}

		}
	}
}
