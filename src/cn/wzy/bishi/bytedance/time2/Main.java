package cn.wzy.bishi.bytedance.time2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<Integer> group1 = new ArrayList<>();
		List<Integer> group2 = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			group1.add(scanner.nextInt());
		}
		for (int i = 0; i < n; i++) {
			group2.add(scanner.nextInt());
		}
		if (n == 1) {
			if (group1.get(0) < group2.get(0)) {
				System.out.println(-1);
			} else if (group1.get(0) == group2.get(0)) {
				System.out.println(0);
			} else {
				System.out.println(1);
			}
		}
		group1.sort((a, b) -> b - a);
		group2.sort((a, b) -> b - a);
		int win = 0;
		int equals = 0;
		for (int i = 0; i < group1.size(); i++) {
			int now = group1.get(i);
			int index = getIndex(group2, now);
			if (index == -1) {
				break;
			}
			int other = group2.get(index);
			if (now > other) {
				win++;
			} else {
				equals++;
			}
			group1.remove(i);
			group2.remove(index);
			i--;
		}
		System.out.println(win - (n - win - equals));
	}

	static int getIndex(List<Integer> list, Integer now) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) <= now)
				return i;
		}
		return -1;
	}
}
