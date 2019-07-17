package cn.wzy.bishi.bytedance.time2;

import java.util.LinkedList;

public class Buke {

	public static void main(String[] args) {
		int[] array = new int[]{2, 4, 5, 3, 1};
		LinkedList<Integer> list = new LinkedList<>();
		list.add(array[0]);
		list.add(array[1]);
		for (int i = 2; i < array.length; i++) {
			list.add(list.poll());
			list.add(array[i]);
		}
		System.out.println(list);
	}
}
