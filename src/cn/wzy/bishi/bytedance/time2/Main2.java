package cn.wzy.bishi.bytedance.time2;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {


	static boolean next(int[] nums) {
		int len = nums.length;
		int index1 = len;
		for (int i = len - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				index1 = i;
				break;
			}
		}
		if (index1 == len)
			return false;
		int index2 = len - 1;
		for (int i = len - 1; i > index1; i--) {
			if (nums[i] > nums[index1]) {
				index2 = i;
				break;
			}
		}
		int a = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = a;

		for (int i = index1 + 1, j = len - 1; i < j; i++, j--) {
			int b = nums[i];
			nums[i] = nums[j];
			nums[j] = b;
		}
		return true;
	}

	static boolean ans(int[] high, int m) {
		for (int i = 1; i < high.length - 1; i++) {
			if (Math.abs(high[i]-high[i - 1]) > m
			|| Math.abs(high[i]-high[i + 1]) > m)
				return false;
		}
		if (Math.abs(high[0]-high[1]) > m ||
			Math.abs(high[0]-high[high.length - 1]) > m)
			return false;
		return true;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] high = new int[n];
		for (int i = 0; i < n; i++) {
			high[i] = scanner.nextInt();
		}
		Arrays.sort(high);
		int ans = ans(high, m)? 1: 0;
		while (next(high)) {
			if (ans(high, m)) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
