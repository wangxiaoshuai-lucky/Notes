package cn.wzy.algorithm;

public class SumOfThree {

	/**
	 * 找出三个数和为sum
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3, 5, 6, 8, 9, 12, 16, 18, 21, 23, 25, 27, 28, 31, 32, 35, 58, 60, 61, 63};
		int sum = 40;
		for (int i = 0; i < nums.length; i++) {
			//nums[i]为第一个数
			//再找两个数加起来为sum - nums[i]
			int l = 0, r = nums.length - 1;
			while (l < r) {
				if (l == i)
					l++;
				else if (r == i)
					r--;
				else if (nums[l] + nums[r] < sum - nums[i])
					l++;
				else if (nums[l] + nums[r] > sum - nums[i])
					r--;
				else if (nums[l] + nums[r] == sum - nums[i])
					break;
			}
			if (l < r)
				System.out.println(nums[i] + "+" + nums[l] + "+" + nums[r] + "=" + sum);
		}
	}
}
