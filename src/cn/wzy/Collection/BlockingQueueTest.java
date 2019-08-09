package cn.wzy.Collection;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author `wangzy`
 * @version 1.0
 * @since 2019/8/9 10:27
 **/
public class BlockingQueueTest {
    /**
     * java 通过线程池可以实现本地异步任务队列
     * 队列的最大值达到Integer.MAX_VALUE 21亿
     * @param args args
     * @throws InterruptedException take时抛出异常
     */
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Integer> deque = new LinkedBlockingQueue<>();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.pow(2, 31));
        deque.add(23);
        System.out.println(deque.take());
    }
}
