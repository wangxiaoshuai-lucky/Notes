package cn.wzy.bishi.wangyi;

import java.util.Scanner;

import static java.lang.Math.abs;

public class Main1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] param = scan.next().split(",");
		String str1 = param[0];
		String str2 = param[1];
		int[] dp = new int[str1.length()];
		if (str1.charAt(0) != str2.charAt(0))
			dp[0] = 1;
		for (int i = 1; i < str1.length(); i++) {
			int a = str1.charAt(i) - '0';
			int b = str2.charAt(i) - '0';
			dp[i] = dp[i - 1] + abs(a - b);
		}
		System.out.println(dp[str1.length() - 1]);
	}
}
