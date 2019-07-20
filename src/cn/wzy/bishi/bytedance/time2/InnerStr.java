package cn.wzy.bishi.bytedance.time2;

import java.util.HashMap;
import java.util.Map;

public class InnerStr {


	static boolean hasInner(String a, String b) {
		if (a.length() > b.length())
			return false;
		Map<Character,Integer> map1 = new HashMap<>();
		for (int i = 0; i < a.length(); i++) {
			Integer val = map1.get(a.charAt(i));
			if (val == null)
				val = 0;
			map1.put(a.charAt(i), val + 1);
		}
		Map<Character,Integer> map2 = new HashMap<>();
		for (int i = 0; i < a.length(); i++) {
			Integer val = map2.get(b.charAt(i));
			if (val == null)
				val = 0;
			map2.put(b.charAt(i), val + 1);
		}
		if (equals(map1, map2))
			return true;
		for (int i = a.length(); i < b.length(); i++) {
			map2.put(b.charAt(i - a.length()), map2.get(b.charAt(i - a.length())) - 1);
			Integer val = map2.get(b.charAt(i));
			if (val == null)
				val = 0;
			map2.put(b.charAt(i), val + 1);
			if (equals(map1, map2))
				return true;
		}
		return false;
	}

	static boolean equals(Map<Character, Integer> map1, Map<Character, Integer> map2) {
		for (Character key: map1.keySet()) {
			if (!map1.get(key).equals(map2.get(key))) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		String a = "aas";
		String b = "sdassawwf";
		System.out.println(hasInner(a, b));
	}
}
