package cn.wzy.bishi.bytedance.time2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HasCircle {

	static int[][] map;

	static int[] time;

	static int n;

	static List<Integer> removeList = new ArrayList<>();

	static void top() {
		for (int i = 0; i < n; i++) {
			if (time[i] == 0 && !removeList.contains(i)) {
				remove(i);
				removeList.add(i);
				return;
			}
		}
	}

	private static void remove(int s) {
		for (int i = 0; i < s; i++) {
			if (map[s][i] == 1) {
				map[s][i] = 0;
				time[i]--;
			}
		}
	}

	static List<List<Integer>> lists = new ArrayList<>();

	static boolean[] visit;

	static void bfs(int now, List<Integer> path) {
		if (path.contains(now)) {
			int index = path.indexOf(now);
			List<Integer> save = new ArrayList<>();
			for (int i = index; i < path.size(); i++) {
				save.add(path.get(i));
			}
			lists.add(save);
			return;
		}
		path.add(now);
		visit[now] = true;
		for (int i = 0; i < n; i++) {
			if (map[now][i] == 1) {
				bfs(i, path);
			}
		}
		path.remove(path.get(path.size() - 1));
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		int m = scanner.nextInt();
		map = new int[n][n];
		time = new int[n];
		visit = new boolean[n];
		for (int i = 0; i < m; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			map[a][b] = 1;
			time[b]++;
		}
		top();
		for (int i = 0; i < n; i++) {
			if (!visit[i] && time[i] != 0) {
				bfs(i, new ArrayList<>());
			}
		}
		for (List<Integer> list:lists) {
			System.out.println(list);
		}
	}
}
