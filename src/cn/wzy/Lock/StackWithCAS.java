package cn.wzy.Lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicStampedReference;

public class StackWithCAS {
	static AtomicStampedReference<List<Integer>> reference;

	static {
		reference = new AtomicStampedReference<>(new ArrayList<>(), 0);
	}

	static void push(int a) {
		for (;;) {
			int[] version = new int[1];
			List<Integer> old = reference.get(version);
			List<Integer> newList = new ArrayList<>(old);
			newList.add(a);
			if (reference.compareAndSet(old,newList, version[0], version[0] + 1)) {
				break;
			}
		}
	}


	public static void main(String[] args) {

	}
}
