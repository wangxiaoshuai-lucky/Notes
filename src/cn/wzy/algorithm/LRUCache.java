package cn.wzy.algorithm;

import java.util.*;

public class LRUCache {

	static Map<String, CacheNode> cahce = new HashMap<>();

	static CacheNode head = new CacheNode("-1","-1");

	static CacheNode tail = new CacheNode("-1","-1");

	static void init() {
		head.next = tail;
		tail.pre = head;
	}

	static int size = 0;

	static int capacity = 3;

	static class CacheNode{
		CacheNode pre;
		CacheNode next;
		String key;
		String value;
		CacheNode(String key, String value){
			this.key = key;
			this.value = value;
		}
	}

	static void put(String key, String value){
		CacheNode node = cahce.get(key);
		if (node == null) {
			node = new CacheNode(key,value);
			addToFirst(node);
		} else {
			node.value = value;
			moveToFirst(node);
		}
	}

	static String get(String key) {
		CacheNode node = cahce.get(key);
		if (node == null) {
			return null;
		} else {
			moveToFirst(node);
			return node.value;
		}
	}

	static void moveToFirst(CacheNode node){
		remove(node);
		addToFirst(node);
	}

	static void addToFirst(CacheNode node){
		cahce.put(node.key, node);
		node.next = head.next;
		head.next.pre = node;
		node.pre = head;
		head.next = node;
		size++;
		if (size > capacity) {
			remove(tail.pre);
		}
	}

	static void remove(CacheNode node){
		node.pre.next = node.next;
		node.next.pre = node.pre;
		size--;
		cahce.remove(node.key);
	}

	static void print(){
		CacheNode p = head.next;
		while (p != tail) {
			System.out.println(p.key + "," + p.value);
			p = p.next;
		}
		System.out.println("=====================");
	}
	public static void main(String[] args) {
		LRUCache.init();
		LRUCache.put("1","22");
		print();
		LRUCache.put("1","22");
		print();
		LRUCache.put("2","22");
		print();
		LRUCache.put("3","22");
		print();
		LRUCache.put("4","22");
		print();
		LRUCache.get("1");
		print();
	}
}
