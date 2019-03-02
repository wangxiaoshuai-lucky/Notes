package cn.wzy.algorithm;
import java.util.*;
public class Main{
	static List<Integer> stack = new ArrayList<>();

	static int query() {
		if (stack.isEmpty())
			return 0;
		else
			return stack.get(0);
	}
	static void pop() {
		if (!stack.isEmpty()) {
			stack.remove( 0);
		}
	}
	static void push(Integer i) {
		stack.add(0, i);
	}
	static void delete(Integer i) {
		int index = stack.indexOf(i);
		if (index != -1)
			stack.remove(index);
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			String cmd = scan.next();
			switch (cmd) {
				case "push":{
					int next = scan.nextInt();
					push(next);
					break;
				}
				case "delete":{
					int next = scan.nextInt();
					delete(next);
					break;
				}
				case "pop":{
					pop();
					break;
				}
				case "query":{
					System.out.println(query());
					break;
				}
			}
		}
	}
}