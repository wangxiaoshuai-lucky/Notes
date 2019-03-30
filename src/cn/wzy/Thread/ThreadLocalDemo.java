package cn.wzy.Thread;

public class ThreadLocalDemo {


	static ThreadLocal<String> str = new ThreadLocal<>();

	static void set(String a){
		str.set(a);
	}
	static void print(){
		System.out.println(str.get());
	}

	public static void main(String[] args) {
		ThreadLocalDemo demo = new ThreadLocalDemo();
		demo.set("main");
		Thread a = new Thread(()->{
			demo.set("aa");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			demo.print();
		}
		);

		Thread b = new Thread(()->{
			demo.set("bb");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			demo.print();
		}
		);

		a.start();
		b.start();
		while (a.isAlive() || b.isAlive()){
			Thread.yield();
		}
		demo.print();
	}
}
