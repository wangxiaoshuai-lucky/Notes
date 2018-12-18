package cn.wzy.Collection;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		LinkedBlockingDeque<Integer> queue = new LinkedBlockingDeque<>(12);
		queue.put(12);
		queue.take();
		HashMap<String, String> map = new HashMap<>();
		map.put("key1", "value1");
		ConcurrentHashMap<String, String> map1 = new ConcurrentHashMap<>();
		map1.size();
		map1.put("asdf", "asdf");
	}
}
