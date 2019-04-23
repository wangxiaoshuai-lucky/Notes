package cn.wzy.bishi.meituan;

import java.util.Scanner;

public class Main {
	static int n, m;
	static int[][] map;
	static int[][] newMap;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		map = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				map[i][j] = scan.nextInt();
		newMap = new int[n][m];
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < m; j++) {
					if (j % 2 == 0) {
						newMap[i][j] = map[0][0];
					} else
						newMap[i][j] = map[0][0] + 1;
				}
			} else {
				for (int j = 0; j < m; j++) {
					if (j % 2 == 0) {
						newMap[i][j] = map[0][0] + 1;
					} else
						newMap[i][j] = map[0][0];
				}
			}
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != newMap[i][j]) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
