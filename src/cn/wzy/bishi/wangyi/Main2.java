package cn.wzy.bishi.wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	static List<List<Integer>> map = new ArrayList<>();
	static int mountCount;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for (int i = 0; i <= n; i++) {
			map.add(new ArrayList());
		}
		while (scan.hasNext()) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			map.get(a).add(b);
			map.get(b).add(a);
			if (b == 4)
				break;
		}
		while (handleMulti()){
			mountCount++;
		}
		handleCircle();
		System.out.println(mountCount);
	}

	static List<Integer> path = new ArrayList<>();
	private static void handleCircle() {
		for (int i = 1; i < map.size(); i++) {
			path.clear();
			if (!dfs(i,i)) {
				mountCount++;
			}
		}
	}

	private static boolean dfs(int pre, int now) {
		if (path.contains(now)) {
			map.get(pre).remove((Object)now);
			map.get(now).remove((Object)pre);
			return false;
		}
		path.add(now);
		for (Integer dest: map.get(now)) {
			if (dest != pre) {
				if(!dfs(now, dest)){
					return false;
				}
			}
		}
		return true;
	}

	private static boolean handleMulti() {
		for (int i = 1; i < map.size(); i++) {
			if (map.get(i).size() >= 3) {
				int dest = map.get(i).get(2);
				map.get(i).remove((Object)dest);
				map.get(dest).remove((Object)i);
				return true;
			}
		}
		return false;
	}
}
