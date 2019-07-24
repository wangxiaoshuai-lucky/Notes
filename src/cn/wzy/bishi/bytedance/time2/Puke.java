package cn.wzy.bishi.bytedance.time2;

public class Puke {

	static int[] nums;

	static int[] dp;

	// 表示从index开始先手能获得的最大价值
	static int getMax(int total, int index, int k) {
		if (dp[index] != -1) {
			return dp[index];
		}
		// 全部拿完
		if (index + k >= nums.length) {
			int sum = 0;
			for (int i = index; i < nums.length; i++) {
				sum += nums[i];
			}
			return sum;
		}
		int val = 0;
		int min = 99999;
		//计算对手最少拿多少
		for (int i = index; i < index + k; i++) {
			val += nums[i];
			int otherTake = getMax(total - val, i + 1, k);
			if (min > otherTake)
				min = otherTake;
		}
		// 减去对手拿的就是自己的
		return dp[index] = total - min;
	}

	public static void main(String[] args) {
		nums = new int[]{3, -4, 1, 1, 7};
		dp = new int[nums.length];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		System.out.println(getMax(sum, 0, 2));
	}
}
