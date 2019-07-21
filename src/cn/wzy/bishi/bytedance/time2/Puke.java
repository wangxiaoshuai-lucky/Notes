package cn.wzy.bishi.bytedance.time2;

public class Puke {

	static int[] nums;

	// 表示从index开始先手能获得的最大价值
	static int getMax(int total, int index, int k) {
		if (index + k >= nums.length) {
			int sum = 0;
			for (int i = index; i < nums.length; i++) {
				sum += nums[i];
			}
			return sum;
		}
		int val = 0;
		int min = 99999;
		for (int i = index; i < index + k; i++) {
			val += nums[i];
			int otherTake = getMax(total - val, i + 1, k);
			if (min > otherTake)
				min = otherTake;
		}
		return total - min;
	}

	public static void main(String[] args) {
		nums = new int[]{1, 1, 1, 1, 1};
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		System.out.println(getMax(sum, 0, 2));
	}
}
