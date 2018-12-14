package cn.wzy.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		ReadWriteLock rwLock = new ReentrantReadWriteLock();
	}
}
