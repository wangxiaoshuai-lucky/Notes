package cn.wzy.bishi.tencent.time1;

import java.util.Scanner;

public class Main4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] bags = new int[n + 1];
		int total = 0;
		for (int i = 1; i <= n; i++) {
			bags[i] = scanner.nextInt();
			total += bags[i];
		}
		int[] people = new int[n + 1];
		int[] change = new int[n + 1];
		people[1] = m;
		int time = 1;
		while (total > 0) {
			time++;
			for (int i = 1; i <= n; i++) {
				if (bags[i] > people[i]) {
					bags[i] -= people[i];
					total -= people[i];
				} else {
					total -= bags[i];
					bags[i] = 0;
					if (i != n) {
						change[i + 1] += people[i] - bags[i];
						change[i] -= people[i] - bags[i];
					}
				}
			}
			for (int i = 1; i <= n; i++) {
				people[i] += change[i];
				change[i] = 0;
				System.out.print(people[i] + " ");
			}
			System.out.println();
		}
		System.out.println(time);
	}
}
