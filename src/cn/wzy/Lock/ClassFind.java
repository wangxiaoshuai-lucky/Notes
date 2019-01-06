package cn.wzy.Lock;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ClassFind {
	/**
	 * java 常用并发类
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		/**
		 * 1.ConcurrentHashMap
		 */
		ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
		concurrentHashMap.putIfAbsent("abc","abc");
		HashMap<String,String> hashMap = new HashMap<>();
		Iterator<String> iterator = concurrentHashMap.keySet().iterator();
		/**
		 * 2.LinkedBlockingDeque
		 */
		LinkedBlockingDeque<Integer> linkedBlockingDeque = new LinkedBlockingDeque(15);
		linkedBlockingDeque.add(12);
		linkedBlockingDeque.pop();
		linkedBlockingDeque.put(12);
		linkedBlockingDeque.take();
		/**
		 * 3.Semaphore
		 */
		Semaphore semaphore = new Semaphore(2);
		semaphore.acquire();
		semaphore.release();
		/**
		 * 4.CountDownLatch
		 */
		CountDownLatch countDownLatch = new CountDownLatch(1);
		countDownLatch.await();
		countDownLatch.countDown();
		/**
		 * 5.CyclicBarrier
		 */
		CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
		cyclicBarrier.await();
		ReentrantLock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		condition.signal();
	}
}
