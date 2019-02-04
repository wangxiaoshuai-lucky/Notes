package cn.wzy.Collection;

public class Main {
	public static void main(String[] args) {
		/**
		 * Integer 会缓存 -127~127的数
		 */
		Integer a = 500;//相当于Integer.valueOf(500)
		Integer b = 500;
		System.out.println(a == b);
		Integer c = 120;
		Integer d = 120;
		System.out.println(c == d);
	}
}
