package cn.wzy.Collection;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int score = scan.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = scan.nextInt();
		}
		int sum =( (Double) Math.pow(2, n - score)).intValue();
		System.out.println(c(score,n) * sum);
	}
	static int c(int a, int b) {
		Double sum = 1.0;
		for (int i = b, j = 0; j < a; i--, j++) {
			sum *= i;
		}
		for (int i = a; i > 1; i--) {
			sum /= i;
		}
		return sum.intValue();
	}
}
