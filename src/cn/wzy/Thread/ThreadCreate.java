package cn.wzy.Thread;

import java.util.concurrent.*;

public class ThreadCreate {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(5);
		FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				Thread.sleep(5000);
				return 111;
			}
		});
		executor.execute(task);
		executor.shutdown();
		long completedTaskCount = executor.getCompletedTaskCount();
		System.out.println(completedTaskCount);
		System.out.println(task.get());
	}
}
