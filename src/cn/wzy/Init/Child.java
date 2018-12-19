package cn.wzy.Init;

import java.io.Serializable;

public class Child extends Base implements Serializable {



	public transient int i;

	static {
		System.out.println("child static 初始化");
	}

	{
		System.out.println("child primary 初始化");
		i = 15;
	}

	public Child() {
		System.out.println("child constructor 初始化");
	}
}
