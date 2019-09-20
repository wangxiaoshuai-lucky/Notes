package cn.wzy.bishi.tencent.time2;

import java.util.Scanner;

public class Main {

	static boolean change(String origin) {
		if (origin.startsWith("8") && origin.length() == 11) {
			return true;
		}
		if (origin.length() < 11) {
			return false;
		}
		int index = origin.indexOf("8");
		if (index == -1) {
			return false;
		}
		return origin.length() - index >= 11;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 0; i < t; i++) {
			scan.next();
			String origin = scan.next();
			if (change(origin)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
