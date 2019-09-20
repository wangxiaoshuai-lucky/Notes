package cn.wzy.bishi.tencent.time2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {

	static boolean change(List<Integer> q1, Integer q2, int sum1, int sum2) {
		int gap = sum1 - sum2;
		if (gap <= 1 && gap >= -1) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			int sum1 = 0, sum2 = 0;
			int num1 = 0, num2 = 0;
			List<Integer> score = new ArrayList<>(n);
			for (int j = 0; j < n; j++) {
				score.add(scanner.nextInt());
			}
			score.sort((a, b) -> b - a);
			List<Integer> queue1 = new ArrayList<>(n / 2 + 1);
			List<Integer> queue2 = new ArrayList<>(n / 2 + 1);
			for (int j = 0; j < n; j++) {
				if (num1 < n / 2 && sum1 < sum2 || num2 >= n / 2) {
					num1++;
					sum1 += score.get(j);
					queue1.add(score.get(j));
				} else {
					num2++;
					sum2 += score.get(j);
					queue2.add(score.get(j));
				}
			}
			while (true) {
				int gap = sum1 - sum2;
				if (gap < 0) {
					gap *= -1;
				}
				if (gap <= 1 && gap >= -1) {
					break;
				}
				boolean flag = false;
				for (int j = 0; j < queue1.size(); j++) {
					for (int k = 0; k < queue2.size(); k++) {
						int nowGap = sum1 - queue1.get(j) + queue2.get(k) -
							(sum2 + queue1.get(j) - queue2.get(k));
						if (nowGap > 0) {
							nowGap*=-1;
						}
						if (nowGap < gap) {
							sum1 = sum1 - queue1.get(j) + queue2.get(k);
							sum2 = sum2 + queue1.get(j) - queue2.get(k);
							int a = queue1.get(j);
							int b = queue2.get(k);
							queue1.set(j, b);
							queue2.set(k, a);
							flag = true;
						}
					}
				}
				if (!flag) {
					break;
				}
			}
			System.out.println(Integer.min(sum1, sum2) + " " + Integer.max(sum1, sum2));
		}
	}
}
