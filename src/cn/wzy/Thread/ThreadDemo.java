package cn.wzy.Thread;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadDemo {
	public static void main(String[] args) {
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
		for (int i = 0; i < 30; i++) {
			final int index = i;
			if (i == 0) {
				executor.scheduleAtFixedRate(()->
						System.out.println("现在时间 : " + System.currentTimeMillis() + " , 我在运行.")
				,0,2, TimeUnit.SECONDS);
			} else {
				executor.execute(()->{
					System.out.println("我不是延迟任务，我优先级最高，我是任务" + index);
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
