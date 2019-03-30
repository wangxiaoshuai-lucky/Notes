package cn.wzy.Leedcode;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.primePalindrome(192);
	}

	public boolean isPrime(int i) {
		if (i == 2 || i == 3)
			return true;
		int m = 2;
		while (m * m <= i) {
			if (i % m == 0)
				return false;
			m++;
		}
		return true;
	}

	public int next(int a) {
		List<Integer> nums = new ArrayList<>();
		while (a != 0) {
			nums.add(0,a % 10);
			a /= 10;
		}
		int right = nums.size() / 2;
		int left = nums.size() % 2 == 0 ? right - 1: right;
		while (left >= 0) {
			int tmp = nums.get(left);
			if (tmp < 9) {
				nums.set(left, tmp + 1);
				nums.set(right, tmp + 1);
				for (int i = left + 1; i < right; i++)
					nums.set(i,0);
				int sum = 0;
				for (int i = 0; i < nums.size(); i++) {
					sum = sum * 10 + nums.get(i);
				}
				return sum;
			}
			left--;
			right++;
		}
		int sum = 1;
		for (int i = 0; i < nums.size(); i++) {
			sum *= 10;
		}
		sum += 1;
		return sum;
	}
	public int primePalindrome(int N) {
		int start = 0;
		while (start < N || !isPrime(start)) {
			start = next(start);
		}
		return start;
	}
}
