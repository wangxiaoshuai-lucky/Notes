package cn.wzy.Collection;

public class Main {
	public static void main(String[] args) {
		float a = 1;
		a = a + 1;
		System.out.println(a);
//		System.out.println("ans is : " + ans());
	}

	public static int ans(){
		try {
			int a = 12 / 0;
			return 1;
		} finally {
			System.out.println("finally.");
			return 3;
		}
	}
}
