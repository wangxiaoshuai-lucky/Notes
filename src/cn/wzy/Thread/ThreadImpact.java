package cn.wzy.Thread;

public class ThreadImpact {

	public static void main(String[] args) {
		Thread a = new Thread(()->{
			for (int i = 0; i < 10; i++) {
				System.out.println("====A====");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread b = new Thread(()->{
			for (int i = 0; i < 10; i++) {
				System.out.println("====B====");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (i == 5) {
					throw new RuntimeException("退出");
				}
			}
		});
		a.start();
		b.start();
	}
}
