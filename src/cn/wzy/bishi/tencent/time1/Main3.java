package cn.wzy.bishi.tencent.time1;

import java.util.List;
import java.util.Scanner;

import static java.lang.Math.min;

public class Main3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		a = new int[n + 1];
		b = new int[n + 1];
		visit = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = scanner.nextInt();
			b[i] = scanner.nextInt();
		}
		for (int i = 1; i <= n; i++) {
			visit[i] = true;
			dfs(1, b[i] * (n - 1));
			visit[i] = false;
		}
		System.out.println(min);
	}

	static int[] a;
	static int[] b;
	static boolean[] visit;
	static int n;
	static int min = Integer.MAX_VALUE;
	static void dfs(int step, int cost) {
		if (step == n) {
			min = min(min, cost);
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				dfs(step + 1, cost + a[i] * (step) + b[i] * (n - step - 1));
				visit[i] = false;
			}
		}
	}
}
