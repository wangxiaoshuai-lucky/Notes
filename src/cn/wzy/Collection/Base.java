package cn.wzy.Collection;

public class Base implements Comparable{
	private Base next;
	static void say(){
		System.out.println("base");
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}
}
