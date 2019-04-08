package cn.wzy.bishi.xiecheng;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] param = scan.next().split(",");
		if (param == null || param.length == 0) {
			System.out.println(false);
			return;
		}
		Set<String> set = new HashSet<>();
		for (String str: param) {
			if (set.contains(str)) {
				System.out.println(true);
				return;
			}
			set.add(str);
		}
		System.out.println(false);
	}
}
