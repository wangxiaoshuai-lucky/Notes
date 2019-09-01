package cn.wzy.bishi.tencent;

import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int single = 0;
		int dou = 0;
		for (int i = 0; i < n; i++) {
			if (scan.nextInt() % 2 == 0) {
				dou++;
			} else {
				single++;
			}
		}
		int ans = 0;
		for (int i = 0; i < m; i++) {
			int a = scan.nextInt();
			if (a % 2 == 0 && single > 0) {
				single--;
				ans++;
			} else if (a % 2 == 1 && dou > 0) {
				dou--;
				ans++;
			}
		}
		System.out.println(ans);
	}
}
