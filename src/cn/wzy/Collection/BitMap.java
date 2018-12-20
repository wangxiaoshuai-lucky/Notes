package cn.wzy.Collection;

import java.util.HashMap;
import java.util.Random;

public class BitMap {

	static int[] map = new int[500];

	static boolean add(int now) {
		int index = now / 32;//得到存储数
		int bit = now % 32;//得到第几位
		if (bit == 0) {
			index--;
			bit = 32;
		}
		bit--;
		boolean res = (map[index] >> bit & 1) == 1;
		map[index] = map[index] | (1 << bit);
		return res;
	}

	public static void main(String[] args) {
		Random random = new Random();
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < 5000; i++) {
			int num = random.nextInt(32 * 500) + 1;
			System.out.println("the answer is : " + (add(num) == hashMap.containsKey(num)));
			hashMap.put(num,1);
		}
	}
}
