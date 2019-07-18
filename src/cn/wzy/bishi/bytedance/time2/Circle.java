package cn.wzy.bishi.bytedance.time2;

import static java.lang.Math.*;

public class Circle {


	/**
	 * 表示在 I点走 k步回到0的走法
	 * @param i
	 * @param k
	 * @return
	 */
	static int n;

	static int getTime(int i, int k) {
		if (i == 1 && k == 1)
			return 1;
		if (i == n - 1 && k == 1)
			return 1;
		if (k == 0)
			return 0;
		return getTime((i - 1 + n) % n, k - 1) + getTime((i - 1 + n) % n, k - 1);
	}

	public static void main(String[] args) {
		int k = 4;
		n = 4;
		System.out.println(getTime(0, 4));
	}
}
