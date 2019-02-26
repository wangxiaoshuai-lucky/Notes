package cn.wzy.algorithm;

public class TryCatch {
	public static void main(String[] args) {
		System.out.println(f());
	}

	static int f(){
		int a = 5;
		try {
			a = 15;
			return a;
		} finally {
			a++;
		}
	}
}
