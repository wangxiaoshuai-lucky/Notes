package cn.wzy.bishi.meituan.time2;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		boolean isB = true;
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 1) {
				System.out.print("A");
			} else if (isB) {
				System.out.print("B");
				isB = false;
			} else {
				System.out.print("C");
				isB = true;
			}
		}
	}
}
