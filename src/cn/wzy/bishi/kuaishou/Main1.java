package cn.wzy.bishi.kuaishou;

import java.util.Scanner;

public class Main1 {
	static int n, m, k;
	static int[][] map;
	static boolean[][] visit;
	static int ans = 0;

	static void dfs(int i, int j) {
		visit[i][j] = true;
		ans++;
		if (i > 0 && !visit[i - 1][j] && success(i - 1, j))
			dfs(i - 1, j);
		if (i < n - 1 && !visit[i + 1][j] && success(i + 1, j))
			dfs(i + 1, j);
		if (j < m - 1 && !visit[i][j + 1] && success(i, j + 1))
			dfs(i, j + 1);
		if (j > 0 && !visit[i][j - 1] && success(i, j - 1))
			dfs(i, j - 1);
	}

	static boolean success(int i, int j) {
		int sum = 0;
		while (i > 0) {
			sum += i % 10;
			i /= 10;
		}
		while (j > 0) {
			sum += j % 10;
			j /= 10;
		}
		if (sum > k)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		k = scan.nextInt();
		map = new int[n][m];
		visit = new boolean[n][m];
		dfs(0, 0);
		System.out.println(ans);
	}
}
