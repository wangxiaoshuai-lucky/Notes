package cn.wzy.bishi.bytedance.time2;


public class MinEditor {

	public static void main(String[] args) {
		String a = "1235";
		String b = "1245";
		int[][] dp = new int[a.length()][b.length()];
		for (int i = 0; i < a.length(); i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i < b.length(); i++) {
			dp[0][i] = i;
		}
		for (int i = 1; i < a.length(); i++) {
			for (int j = 1; j < b.length(); j++) {
				int t = a.charAt(i) == b.charAt(j) ? 0 : 1;
				dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + t);
			}
		}
		System.out.println(dp[a.length() - 1][b.length() - 1]);
	}

	static int min(int a, int b, int c) {
		return Math.min(Math.min(a, b),c);
	}
}
