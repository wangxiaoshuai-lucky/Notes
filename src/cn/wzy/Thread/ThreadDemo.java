package cn.wzy.Thread;

import java.util.Scanner;

import static java.lang.Math.max;

public class ThreadDemo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.next();
			String a = scanner.next();
			char[] str1 = s.toCharArray();
			char[] str2 = a.toCharArray();
			int[][] dp = new int[str1.length + 1][str2.length + 1];
			int result = 0;
			for (int i = 0; i < str1.length + 1; i++) {
				for (int j = 0; j < str2.length + 1; j++) {
					if (i == 0 || j == 0) {
						dp[i][j] = 0;
					}else if (str1[i - 1] == str2[j - 1]) {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					} else {
						dp[i][j] = 0;
					}
					if (dp[i][j] > result)
						result = dp[i][j];
				}
			}
//		for (int i = 0; i < dp.length; i++) {
//			for (int j = 0; j < dp[0].length; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
			System.out.println(result);
//		System.out.println(lcs(s,a));
		}

	}
	public static int lcs(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		int c[][] = new int[len1+1][len2+1];
		for (int i = 0; i <= len1; i++) {
			for( int j = 0; j <= len2; j++) {
				if(i == 0 || j == 0) {
					c[i][j] = 0;
				} else if (str1.charAt(i-1) == str2.charAt(j-1)) {
					c[i][j] = c[i-1][j-1] + 1;
				} else {
					c[i][j] = max(c[i - 1][j], c[i][j - 1]);
				}
			}
		}
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
		return c[len1][len2];
	}
}
