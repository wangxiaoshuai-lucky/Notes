package cn.wzy.bytedance;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		while ((n--) != 0) {
			int m = scan.nextInt();
			int[] mates = new int[m];
			int min = 0;
			for (int i = 0; i < m; i++) {
				mates[i] = scan.nextInt();
				if (mates[i] < mates[min])
					min = i;
			}
			int[] price = new int[m];
			price[min] = 1;
			int now = min;
			for (; ;) {
				int next = (now + 1) % price.length;
				if (next == min)
					break;
				if (mates[next] > mates[now]) {
					price[next] = price[now] + 1;
				} else if (mates[next] == mates[now]) {
					price[next] = price[now];
				} else {
					price[next] = price[now] - 1;
				}
				now = next;
			}
			now = min;
			for (; ;) {
				int pre = (now + price.length - 1) % price.length;
				if (pre == min)
					break;
				boolean failed = true;
				while (change(mates,price,pre)) {
					failed = false;
				}
				if (failed){
					break;
				} else {
					now = pre;
				}
			}
			int sum = 0;
			for (int i = 0; i < price.length; i++) {
				sum += price[i];
			}
			System.out.println(sum);
		}
	}

	static boolean change(int[] mates, int[] price, int now) {
		int next = (now + 1) % price.length;
		int pre = (now + price.length - 1) % price.length;
		price[now]--;
		if (mates[next] < mates[now] && price[next] >= price[now]) {
			price[now]++;
			return false;
		}
		if (mates[pre] < mates[now] && price[pre] >= price[now]) {
			price[now]++;
			return false;
		}
		return true;
	}
}
