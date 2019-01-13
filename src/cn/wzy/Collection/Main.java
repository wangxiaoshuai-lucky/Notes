package cn.wzy.Collection;

public class Main {
	public static void main(String[] args) {
		System.out.println("ans is : " + ans());
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
