package cn.wzy.weBank;

import java.util.*;

public class Main {

	static int max;
	static int pre;
	static int getLevel(int n){
		int j;
		max = 1;
		for (j = 0; ; j++) {
			pre = max;
			if (j % 2 == 1) {
				max += 1;
			} else {
				max += 2 * j;
			}
			if (max >= n)
				break;
		}
		return j;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()){
			int n = scan.nextInt();
			int j = getLevel(n);
			int gap = max - n;
			if (gap <= j) {
				System.out.println((gap + 1) + "/" + (j - gap + 1));
			} else {
				gap = n - pre;
				System.out.println((gap + 1) + "/" + (j - gap));
			}
		}
	}
}
