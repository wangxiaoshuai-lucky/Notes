package cn.wzy.design_pattern;

import java.util.*;

public class Main {
	static class User{
		String name;
	}
	public static void main(String[] args) {
		System.out.println(getAns());
	}

	static int getAns() {
		int a = 11;
		try {
			a = 12;
			return a;
		} finally {
			a = 13;
			return a;
		}
	}
}
