package cn.wzy.bishi.bytedance.time2;

import java.util.Scanner;

import static sun.swing.MenuItemLayoutHelper.max;

public class Main1 {
	static int[][] items;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		if (m == 0 || n == 0) {
			System.out.println(0);
			return;
		}
		items = new int[m][2];
		for (int i = 0 ; i < m; i++) {
			items[i][0] = scanner.nextInt();
			items[i][1] = scanner.nextInt();
		}
		int[] dp = new  int[n + 1];
		for (int i = 0; i < m; i++) {
			for (int j = n; j >= 1; j--) {
				if (j >= items[i][0])
					dp[j] = max(dp[j],dp[j - items[i][0]] + items[i][1]);
			}
		}
		System.out.println(dp[n]);
	}

	static int dfs(int money, int now, int nowCost, int nowValue) {
		if (now >= items.length)
			return nowValue;
		if (money < nowCost + items[now][0]) {
			return dfs(money, now + 1, nowCost, nowValue);
		} else {
			int yes = dfs(money, now + 1, nowCost + items[now][0], nowValue + items[now][1]);
			int no = dfs(money, now + 1, nowCost, nowValue);
			return yes > no ? yes : no;
		}
	}
}
