package cn.wzy.Collection;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
	public static void main(String[] args) {
		Child child = new Child();
		((Base)child).say();//bases
		(child).say();//child
		HashMap<String,String> map = new HashMap<>();
		map.put("asdf","asdf");
		AtomicInteger integer = new AtomicInteger();
		integer.get();
		AtomicReference<String> reference = new AtomicReference<>();
		reference.get();
		Thread thread = new Thread();
		thread.interrupt();
		Thread.interrupted();
		new ReentrantLock();
	}
}
