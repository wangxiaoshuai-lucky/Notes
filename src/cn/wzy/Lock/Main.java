package cn.wzy.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

	static ReadWriteLock rwLock = new ReentrantReadWriteLock();
	static Lock readLock = rwLock.readLock();
	static Lock write = rwLock.writeLock();
	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			if (i % 2 < 0) {
				new Thread(()->{
					write.lock();
					try {
						System.out.println(Thread.currentThread().getId() + "is starting to write the file");
						Thread.sleep(500);
						System.out.println(Thread.currentThread().getId() + "is completing to write the file");
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						write.unlock();
					}
				}).start();
			} else {
				new Thread(()->{
					readLock.lock();
					try {
						System.out.println(Thread.currentThread().getId() + "is starting to read the file");
						Thread.sleep(500);
						System.out.println(Thread.currentThread().getId() + "is completing to read the file");
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						readLock.unlock();
					}
				}).start();
			}
		}
	}
}
