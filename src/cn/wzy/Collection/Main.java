package cn.wzy.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArraySet;

import static java.lang.Math.min;

public class Main {
	static int[] cons = new int[]{1, 3, 4, 5};

	static int ans(int n) {
		int[] dp = new int[n + 1];
		for (int i = 0; i <= n; i++)
			dp[i] = 99999;
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < 4 && i - cons[j] >= 0; j++) {
				dp[i] = min(dp[i - cons[j]] + 1, dp[i]);
			}
		}
		int ans = dp[n];
		int now = n;
		while ((ans--) != 0) {
			for (int i = 0; i < 4 && now - cons[i] >= 0; i++) {
				if (dp[now - cons[i]] == dp[now] - 1) {
					System.out.println(ans + ": " + cons[i]);
					now -= cons[i];
					break;
				}
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(ans(7));
	}
}
