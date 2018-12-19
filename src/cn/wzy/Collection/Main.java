package cn.wzy.Collection;

import java.util.TreeMap;
import java.util.TreeSet;

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
		TreeSet<Integer> set = new TreeSet();
		set.add(123);

		TreeMap<Integer,Integer> map = new TreeMap<>();
		map.put(1,12);
	}
}
