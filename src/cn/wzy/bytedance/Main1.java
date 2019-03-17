package cn.wzy.bytedance;

import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		while ((n--) != 0) {
			String str = scan.next();
			System.out.println(handle(str));
		}
	}
	static String handle(String str) {
		for (int i = 2; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1) && str.charAt(i) == str.charAt(i - 2)){
				str = str.substring(0, i) + str.substring(i + 1);
				i--;
				continue;
			}
		}
		for (int i = 3; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1) && str.charAt(i - 2) == str.charAt(i - 3)){
				str = str.substring(0, i) + str.substring(i + 1);
				i--;
				continue;
			}
		}
		return str;
	}
}
