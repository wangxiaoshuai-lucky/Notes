package cn.wzy.Collection;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Child child = new Child();
		((Base)child).say();//bases
		(child).say();//child
	}
}
