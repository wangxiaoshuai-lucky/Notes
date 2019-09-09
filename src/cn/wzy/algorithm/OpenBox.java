package cn.wzy.algorithm;

import java.util.*;

public class OpenBox {

	static class Operation implements Comparable<Operation> {
		int time;
		int type;
		int index;

		Operation(int time, int type, int index) {
			this.time = time;
			this.type = type;
			this.index = index;
		}
		@Override
		public int compareTo(Operation obj) {
			if (this.time == obj.time) {
				if (this.type == obj.type) {
					return this.index - obj.index;
				} else {
					return this.type - obj.type;
				}
			} else {
				return this.time - obj.time;
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] keys = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			keys[i] = i;
		}
		List<Operation> opers = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int index = scanner.nextInt();
			int s = scanner.nextInt();
			int l = scanner.nextInt();
			opers.add(new Operation(s, 1, index));
			opers.add(new Operation(s + l, -1, index));
		}
		Collections.sort(opers);
		for (Operation op: opers) {
			if (op.type == -1) {
				for (int i = 1; i <= n; i++) {
					if (keys[i] == 0) {
						keys[i] = op.index;
						break;
					}
				}
			} else {
				for (int i = 1; i <= n; i++) {
					if (keys[i] == op.index) {
						keys[i] = 0;
						break;
					}
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			System.out.print(keys[i] + " ");
		}
	}
}
