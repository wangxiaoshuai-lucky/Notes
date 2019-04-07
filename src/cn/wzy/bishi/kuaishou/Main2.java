package cn.wzy.bishi.kuaishou;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int ans = 0;
		while (a != 0) {
			if ((a & 1) == 1) {
				ans++;
			}
			a >>= 1;
		}
		System.out.println(ans);
	}
}
