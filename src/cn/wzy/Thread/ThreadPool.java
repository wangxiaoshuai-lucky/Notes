package cn.wzy.Thread;

import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 1000L, TimeUnit.MINUTES, new LinkedBlockingDeque<>(), new ThreadPoolExecutor.AbortPolicy());
        executor.allowCoreThreadTimeOut(true);//允许核心线程超时退出

        Future<Integer> future = executor.submit(() -> System.out.println(1), 1);
        System.out.println(future.get());

        Future<Integer> future1 = executor.submit(() -> 10);
        System.out.println(future1.get());

        ScheduledExecutorService schedule = Executors.newScheduledThreadPool(5);
        schedule.scheduleAtFixedRate(() -> System.out.println("sss"), 500, 500, TimeUnit.MILLISECONDS);
        schedule.shutdown();
        executor.shutdown();
        System.out.println("done");
    }
}
