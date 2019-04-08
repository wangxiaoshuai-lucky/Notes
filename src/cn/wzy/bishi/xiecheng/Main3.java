package cn.wzy.bishi.xiecheng;

import java.util.*;

public class Main3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String[] strs = new String[n];
		for (int i = 0; i < n; i++) {
			strs[i] = scan.next();
			if (strs[i].charAt(strs[i].length() - 1) == '/') {
				strs[i] = strs[i].substring(0,strs[i].length() - 1);
			}
			int count = 1;
			for (int j = 0; j < i; j++) {
				if (strs[j].equals(strs[i])){
					count++;
				}
			}
			String[] tmp = strs[i].split("/");
			int len = tmp.length - 1;
			if (count == 1) {
				for (int j = 0; j < len; j++) {
					System.out.print(1);
				}
				if (i != n - 1)
					System.out.print(" ");
			} else {
				for (int j = 0; j < len; j++) {
					if (j == 0 || j == len - 1)
						System.out.print(1);
					else
						System.out.print(count);
				}
				if (i != n - 1)
					System.out.print(" ");
			}
		}
	}
}
