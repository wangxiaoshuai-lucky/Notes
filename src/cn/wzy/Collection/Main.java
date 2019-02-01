package cn.wzy.Collection;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Integer> primary = new ArrayList<>();
		primary.add(2);
		primary.add(3);
		int n = 1000;
		for (int i = 4; i <= n; i++) {
			boolean isPrimary = true;
			for (Integer j: primary) {
				if (i % j == 0) {
					isPrimary = false;
					break;
				}
			}
			if (isPrimary) {
				primary.add(i);
			}
		}
		for (Integer i: primary) {
			System.out.print(i + ",");
		}
	}
}
