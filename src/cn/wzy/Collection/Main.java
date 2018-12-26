package cn.wzy.Collection;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {


	public static void sort(int[] target, int low, int high) {
		if (low >= high) {
			return;
		}
		int i = low, j = high;
		int tmp = target[i];

		while (i < j) {
			while (i < j) {
				if (target[j] < tmp) {
					target[i] = target[j];
					break;
				}
				j--;
			}
			while (i < j) {
				if (target[i] > tmp) {
					target[j] = target[i];
					break;
				}
				i++;
			}
			target[i] = tmp;
		}
		sort(target, low, i - 1);
		sort(target, i + 1, high);
	}

	public static void main(String[] args) {
		ConcurrentHashMap<String, Integer> hashMap = new ConcurrentHashMap<>();
		hashMap.put("asdf",11);
		hashMap.size();
	}
}
