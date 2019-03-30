package cn.wzy.kuaishou;

import java.util.*;

public class Main {

	static List<Integer> list = new ArrayList<>();


	static boolean isRight(int root) {
		if (root > list.size())
			return true;
		int l = root * 2 + 1;
		int r = l + 1;
		if (r > list.size())
			return true;
		if (list.get(l) > list.get(root) || list.get(r) < list.get(root))
			return false;
		return isRight(l) && isRight(r);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] str = scan.next().split(",");
		if(str[0].equals("None")) {
			System.out.println("True");
			return;
		}
		for (String s: str) {
			list.add(Integer.valueOf(s));
		}
		if (isRight(0))
			System.out.println("True");
		else
			System.out.println("False");
	}
}
