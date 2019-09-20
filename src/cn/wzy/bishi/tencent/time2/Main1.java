package cn.wzy.bishi.tencent.time2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

	static class User {
		int n;
		int time;

		public User(int n, int time) {
			this.n = n;
			this.time = time;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<User> users = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			users.add(new User(a, b));
		}
		users.sort((u1, u2) -> u1.time - u2.time);
		int max = -1;
		while (users.size() > 0) {
			User user1 = users.get(0);
			User user2 = users.get(users.size() - 1);
			if (users.size() == 1) {
				max = Integer.max(max, user1.time * 2);
				break;
			}
			max = Integer.max(max, user1.time + user2.time);
			int desc = Integer.min(user1.n, user2.n);
			user1.n -= desc;
			user2.n -= desc;
			if (user1.n == 0) {
				users.remove(user1);
			}
			if (user2.n == 0) {
				users.remove(user2);
			}
		}
		System.out.println(max);
	}
}
