package cn.wzy.Collection;

import java.util.Comparator;

public class Child extends Base implements Comparator<Child> {
	private Base next;
	static void say(){
		System.out.println("child");
	}

	@Override
	public int compare(Child o1, Child o2) {
		return 0;
	}
}
