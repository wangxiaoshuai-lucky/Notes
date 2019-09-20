package cn.wzy.bishi.tencent.time2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		List<Integer> list = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			list.add(scanner.nextInt());
		}
		list.sort((a, b) -> a - b);
		int sum = 0, start = 0;
		for (int i = 0; i < list.size() && m > 0; i++) {
			if (list.get(i) - sum > 0) {
				System.out.println(list.get(i) - sum);
				sum = list.get(i);
				m--;
			}
		}
		for (int i = 0; i < m; i++) {
			System.out.println(0);
		}
	}
}
