package cn.wzy.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadCreate {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		//futureTask
		FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return 12;
			}
		});
		new Thread(futureTask).start();
		System.out.println(futureTask.get());
		//runnable
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(12);
			}
		}).start();
		//extends Thread
		class MyThread extends Thread{
			@Override
			public void run() {
				System.out.println(12);
			}
		}
		new MyThread().start();
	}
}
