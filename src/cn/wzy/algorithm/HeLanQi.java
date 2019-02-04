package cn.wzy.algorithm;

public class HeLanQi {

	public static void main(String[] args) {
		int[] nums = new int[20];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i % 3;
		}

		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
		System.out.println();
		int red = -1, white = nums.length;
		for (int i = 0; i < white; i++) {
			if (nums[i] == 0) {
				swap(nums,++red,i);
			} else if (nums[i] == 2) {
				swap(nums,--white,i);
				i--;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
	}

	static void swap(int[] target, int x, int y) {
		int tmp = target[x];
		target[x] = target[y];
		target[y] = tmp;
	}
}
