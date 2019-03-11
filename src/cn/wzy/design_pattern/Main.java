package cn.wzy.design_pattern;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
		threadLocal.set(123);
		threadLocal.get();
	}
}
