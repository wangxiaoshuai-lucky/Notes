package cn.wzy.bishi.bytedance.time2;

public class Main3 {
	public static void main(String[] args) {
		int[] nums = new int[]{1, -2, 66, 1, -2, -8, 7};
		int sum = 0, start = 0, end = 0;
		int max = -1, s = -1, e = -1;
		for (int i = 0; i < nums.length; i++) {
			if (sum + nums[i] >= nums[i]) {
				sum += nums[i];
				end = i;
			} else {
				sum = nums[i];
				start = i;
			}
			if (max < sum) {
				max = sum;
				s = start;
				e = end;
			}
		}
		System.out.println(max + ":" + s + "," + e);
	}
}
