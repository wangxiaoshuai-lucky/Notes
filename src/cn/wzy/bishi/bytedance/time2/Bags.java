package cn.wzy.bishi.bytedance.time2;

public class Bags {

	public static void main(String[] args) {
		int[][] bags = new int[][] {
			{4, 1},
			{10, 15},
			{14, 20},
			{14, 15},
			{15, 30},
		};
		int money = 100;
		int[] dp = new int[money + 1];
		for (int i = 0; i < bags.length; i++) {
			for (int j = money; j > 0; j--) {
				int t = j / bags[i][0];
				for (int k = 1; k <= t; k++) {
					dp[j] = Math.max(dp[j], dp[j - k * bags[i][0]] + k * bags[i][1]);
				}
			}
		}
		int last = money;
		for (int i = 0; i < bags.length; i++) {
			int t = last / bags[i][0];
			for (int j = t; j > 0; j--) {
				if (dp[last] == dp[last - j * bags[i][0]] + j * bags[i][1]) {
					System.out.println(String.format("买了%d个%d商品", j, i));
					last -= j * bags[i][0];
					break;
				}
			}
		}
		System.out.println("总价为" + dp[money]);
	}
}
