package cn.wzy.Thread;

import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(11);
            }
        });
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 111L, TimeUnit.MINUTES, new LinkedBlockingDeque<>(), new ThreadPoolExecutor.AbortPolicy());
        executor.allowCoreThreadTimeOut(true);//允许核心线程超时退出
        ScheduledExecutorService schedule = Executors.newScheduledThreadPool(5);
        schedule.scheduleAtFixedRate(() -> System.out.println("sss"), 500, 500, TimeUnit.MILLISECONDS);
    }
}
