package cn.wzy.algorithm;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class Water {

	static int[] bucket = new int[]{3, 5, 8};

	static Map<String, Integer> map;

	public static void main(String[] args) {
		map = new HashMap<>();
		map.put("000", 0);
		target = 4;
		search("300", 1);
		search("050", 1);
		search("008", 1);
		System.out.println(min);
	}

	static int min = 99999;

	static int target = 0;

	static void search(String now, int step) {
		if (now.contains("" + target)) {
			if (step < min) {
				min = step;
				System.out.println(now + "----" + step);
			}
		}
		if (map.get(now) == null || map.get(now) > step) {
			map.put(now, step);
			int[] nowBucket = string2int(now);
			// 加满
			for (int i = 0; i < 2; i++) {
				if (nowBucket[i] < bucket[i]) {
					int origin = nowBucket[i];
					nowBucket[i] = bucket[i];
					search(int2string(nowBucket), step + 1);
					nowBucket[i] = origin;
				}
			}
			// 倒掉
			for (int i = 0; i < 2; i++) {
				if (nowBucket[i] != 0) {
					int origin = nowBucket[i];
					nowBucket[i] = 0;
					search(int2string(nowBucket), step + 1);
					nowBucket[i] = origin;
				}
			}
			// 互相转移 i -> j
			for (int i = 0; i < 2; i++) {
				if (nowBucket[i] == 0) {
					continue;
				}
				for (int j = 0; j < 2; j++) {
					if (i != j) {
						int origin1 = nowBucket[i];
						int origin2 = nowBucket[j];
						int sum = origin1 + origin2;
						nowBucket[j] = min(sum, bucket[j]);
						nowBucket[i] = max(0, sum - nowBucket[j]);
						search(int2string(nowBucket), step + 1);
						nowBucket[i] = origin1;
						nowBucket[j] = origin2;
					}
				}
			}
		}
	}

	static int[] string2int(String str) {
		return new int[] {
			str.charAt(0) - '0',
			str.charAt(1) - '0',
			str.charAt(2) - '0'
		};
	}

	static String int2string(int[] nums) {
		return nums[0] + "" + nums[1] + "" + nums[2];
	}

}
