package cn.wzy.Collection;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		a = scan.nextInt();
		b = scan.nextInt();
		nums = new int[n];
		ans = new int[n];
		now = new int[n];
		for (int i = 0; i < n; i++)
			if (i < a)
				now[i] = 1;
			else
				now[i] = 2;
		for (int i = 0; i < n; i++)
			nums[i] = scan.nextInt();
		getAns();
		for (int i = 0; i < ans.length; i++) {
			System.out.print( ans[i] + " ");
		}
	}
	static int[] nums;
	static int a;
	static int b;
	static int[] ans;
	static int[] now;
	static double max = 0;
	static void getAns() {
		judge();
		while (next()) {
//			for (int i = 0; i < now.length; i++) {
//				System.out.print( now[i] + " ");
//			}
//			System.out.println();
			judge();
		}
	}
	static void judge() {
		double sum1 = 0, sum2 = 0;
		for (int i = 0; i < now.length; i++) {
			if (now[i] == 1) {
				sum1 += nums[i];
			} else {
				sum2 += nums[i];
			}
		}
		double score = sum1 / a + sum2 / b;
		if (score > max) {
			max = score;
			for (int i = 0; i < now.length; i++) {
				ans[i] = now[i];
			}
		}
	}
	static boolean next() {
		int len = now.length;
		int index = -1;
		for (int i = len - 2; i >= 0; i--) {
			if (now[i] < now[i + 1]) {
				index = i;
				break;
			}
		}
		if (index == -1)
			return false;
		int key = -1;
		for (int i = len - 1; i >= index ; i--) {
			if (now[i] > now[index]) {
				key = i;
				break;
			}
		}
		int tmp = now[key];
		now[key] = now[index];
		now[index] = tmp;
		for (int i = index + 1, j = len - 1;i < j ; i++, j--) {
			tmp = now[i];
			now[i] = now[j];
			now[j] = tmp;
		}
		return true;
	}
}
