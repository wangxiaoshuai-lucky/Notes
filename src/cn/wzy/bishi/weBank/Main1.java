package cn.wzy.bishi.weBank;

import java.util.Scanner;

public class Main1 {
	static int[] nums = new int[7];
	static int sum;

	static void decrease() {
		int[][] graph = new int[6][6];
		for (int i = 6; i >= 0; i--) {
			while (nums[i] > 0) {
				if (load(graph, i)) {
					sum--;
					nums[i]--;
//					System.out.println("load " + i);
				} else {
//					System.out.println("failed " + i);
					break;
				}
			}
		}
	}

	static boolean load(int[][] graph, int n) {
		for (int i = 0; i <= 6 - n; i++) {
			for (int j = 0; j <= 6 - n; j++) {
				int sum = 0;
				for (int k = i; k < i + n; k++) {
					for (int l = j; l < j + n; l++) {
						if (graph[k][l] == 0)
							sum++;
						else
							break;
					}
				}
				if (sum == n * n) {
					for (int k = i; k < i + n; k++) {
						for (int l = j; l < j + n; l++) {
							graph[k][l] = 1;
						}
					}
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int i = 1; i <= 6; i++) {
			nums[i] = scan.nextInt();
			sum += nums[i];
		}
		int count = 0;
		while (sum > 0) {
			decrease();
			count++;
		}
		System.out.println(count);
	}
}
