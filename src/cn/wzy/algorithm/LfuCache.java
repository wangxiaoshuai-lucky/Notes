package cn.wzy.algorithm;

import java.util.HashMap;
import java.util.Map;

public class LfuCache {

	static class Node {
		String key;
		Integer value;
		Integer count;
		Node pre, next;

		Node(String key, Integer value, Integer count) {
			this.key = key;
			this.value = value;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Node{" +
				"key='" + key + '\'' +
				", value=" + value +
				", count=" + count +
				'}';
		}
	}

	Map<String, Node> cache = new HashMap<>();
	Node head = new Node(null, null, Integer.MAX_VALUE);
	Node tail = head;
	int size = 0;

	void add(String key, Integer value) {
		if (cache.containsKey(key)) {
			Node now = cache.get(key);
			now.value = value;
			now.count++;
			update(now);
		} else {
			Node node = new Node(key, value, 1);
			if (size < 5) {
				tail.next = node;
				node.pre = tail;
				tail = node;
				size++;
			} else {
				tail.pre.next = node;
				node.pre = tail.pre;
				tail = node;
			}
			cache.put(key, node);
		}
	}

	void update(Node now) {
		if (now.pre == head) {
			return;
		}
		Node tmp = now.pre;
		while (tmp.count < now.count) {
			tmp = tmp.pre;
		}
		if (tmp.next == now)
			return;
		//del now
		now.pre.next = now.next;
		if (tail != now) {
			now.next.pre = now.pre;
		} else {
			tail = now.pre;
		}
		//insert now
		now.next = tmp.next;
		tmp.next.pre = now;
		now.pre = tmp;
		tmp.next = now;
	}

	Integer get(String key) {
		Node val = cache.get(key);
		if (val == null)
			return -1;
		val.count++;
		update(val);
		return val.value;
	}

	void remove(String key) {
		if (cache.containsKey(key)) {
			size--;
			Node node = cache.remove(key);
			if (node == tail) {
				tail = node.pre;
				node.pre.next = node.next;
			} else {
				node.pre.next = node.next;
				node.next.pre = node.pre;
			}
		}
	}

	void print() {
		Node p = head.next;
		System.out.println("========");
		while (p != null) {
			System.out.println(p);
			p = p.next;
		}
		System.out.println("========");
	}
	public static void main(String[] args) {
		LfuCache cache = new LfuCache();
		cache.print();
		cache.add("a", 11);
		cache.print();
		cache.add("b",111);
		cache.print();
		cache.add("c",111);
		cache.print();
		cache.add("d",111);
		cache.print();
		cache.add("e",111);
		cache.print();
		cache.add("f",111);
		cache.print();
		cache.add("g",111);
		cache.print();
		cache.get("c");
		cache.print();
		cache.get("b");
		cache.print();
		cache.remove("b");
		cache.print();
	}
}
