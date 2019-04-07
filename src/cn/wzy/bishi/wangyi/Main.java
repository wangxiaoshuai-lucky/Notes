package cn.wzy.bishi.wangyi;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Set<Long> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(scan.nextLong());
		}
		System.out.println(set.size());
	}
}
