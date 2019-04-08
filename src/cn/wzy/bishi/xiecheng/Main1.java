package cn.wzy.bishi.xiecheng;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String string = scan.next();
		int a = scan.nextInt();
		if (string.equals("[]")) {
			System.out.println("[]");
			return;
		}
		String[] param = string.substring(1,string.length() - 1).split(",");
		System.out.print("[");
		for (int i = 0; i < param.length;) {
			if (i + a - 1 >= param.length) {
				for (int j = i; j < param.length; j++) {
					System.out.print(param[j]);
					if (j != param.length - 1) {
						System.out.print(",");
					}
				}
				break;
			}
			for (int j = i + a - 1; j >= i; j--) {
				System.out.print(param[j]);
				if (i + a != param.length || j != i) {
					System.out.print(",");
				}
			}
			i += a;
		}
		System.out.print("]");
	}
}
