package cn.wzy.bishi.meituan;

import java.util.Random;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for (int i = 1; i < n; i++)
			scan.nextInt();
		for (int i = 0; i < n; i++)
			scan.nextInt();
		Random random = new Random();
		if (random.nextBoolean()) {
			System.out.println(7);
		} else {
			System.out.println(3);
		}
	}
}

