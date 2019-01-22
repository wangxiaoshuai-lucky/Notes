package cn.wzy.Thread;

import java.util.concurrent.Semaphore;

public class ThreadPrint {

	static class MyThread extends Thread{
		static int i = 0;
		static Semaphore s1 = new Semaphore(1);
		static Semaphore s2 = new Semaphore(0);
		@Override
		public void run() {
			while (true){
				if (i > 100) {
					break;
				}
				try {
					if (Thread.currentThread().getId() % 2 == 1) {
						s2.acquire();
						System.out.println("Thread one :" + i++);
						s1.release();
					} else {
						s1.acquire();
						System.out.println("Thread two :" + i++);
						s2.release();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new MyThread().start();
		new MyThread().start();
	}
}
