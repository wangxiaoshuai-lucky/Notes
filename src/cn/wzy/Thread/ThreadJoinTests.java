package cn.wzy.Thread;

public class ThreadJoinTests {
	public static void main(String[] args) throws InterruptedException {
		Thread a = new Thread(()->{
				System.out.println("start");
		});
		a.run();
		Thread.sleep(3000);
		a.join();
		System.out.println("end");
	}
}
