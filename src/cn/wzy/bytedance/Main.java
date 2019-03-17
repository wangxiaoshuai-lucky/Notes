package cn.wzy.bytedance;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int[] lis;
	static double min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		lis = new int[n];
		for (int i = 0; i < n; i++) {
			lis[i] = scan.nextInt();
			if (min > lis[i])
				min = lis[i];
		}
		Arrays.sort(lis);
		System.out.format("%.2f",(double)lis[n - m]);
//		int maxLen = getMax() * 100 + 1;
//		dp = new int[n][maxLen];
//		for (int j = min; j < maxLen; j++) {
//			dp[0][j] = ((Double)(lis[0] / ((double)j / 100))).intValue();
//		}
//		for (int i = 1; i < n; i++) {
//			for (int j = min; j < maxLen; j++) {
//				dp[i][j] += dp[i - 1][j] + ((Double)(lis[i] / ((double)j / 100))).intValue();
//			}
//		}
//		for (int i = maxLen - 1; i >= min; i--) {
//			if (dp[n - 1][i] >= m){
//				System.out.format("%.2f", ((double) i )  / 100);
//				break;
//			}
//		}
	}
}
