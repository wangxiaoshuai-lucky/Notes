package cn.wzy.bishi.bytedance.time2;

public class StringTest {
	public static void main(String[] args) {
		String name = "aaa#bbb#ccc";
		String[] names = name.split("#");
		System.out.println(name);
		System.out.println(names[0]);
		System.out.println(name == names[0]);
	}
}
