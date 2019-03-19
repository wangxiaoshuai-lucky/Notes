package cn.wzy.baicizhan;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = scan.nextInt();
		int min = nums[0], gap = 1;
		for (int i = 1; i < n; i++) {
			if (nums[i] == min + gap) {
				gap++;
			} else {
				if (gap < 3) {
					while ((gap--) != 0) {
						System.out.println(min++);
					}
				} else {
					System.out.println(min + "-" + (min + gap - 1) + " ");
				}
				min = nums[i];
				gap = 1;
			}
		}
		if (gap < 3) {
			while ((gap--) != 0) {
				System.out.println(min++);
			}
		} else {
			System.out.println(min + "-" + (min + gap - 1) + " ");
		}
	}
}
