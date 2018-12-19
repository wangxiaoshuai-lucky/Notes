package cn.wzy.Init;

public class Base {
	static {
		System.out.println("base static 初始化");
	}

	{
			System.out.println("base primary 初始化");
	}
	public Base() {
		System.out.println("base constructor 初始化");
	}
}
