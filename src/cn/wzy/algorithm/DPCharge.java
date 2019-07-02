package cn.wzy.algorithm;

public class DPCharge {

	public static int getMin(int[] coins, int money) {
		int n = coins.length;
		int[][] dp = new int[n][money + 1];
		for (int i = 0; i < n; i++)
			dp[i][0] = 0;
		for (int i = 1; i <= money; i++)
			dp[0][i] = i / coins[0];
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= money; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j - coins[i] < 0)
					continue;
				int time = j / coins[i];
				for (int k = 1; k <= time; k++) {
					dp[i][j] = Math.min(
						dp[i][j],
						dp[i - 1][j - k * coins[i]] + k
					);
				}
			}
		}
		return dp[n - 1][money];
	}

	public static void main(String[] args) {
		int[] coins = new int[]{1, 3, 4};
		System.out.println(getMin(coins, 6));
	}
}
