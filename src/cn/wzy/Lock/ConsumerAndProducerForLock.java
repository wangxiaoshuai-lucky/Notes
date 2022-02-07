package cn.wzy.Lock;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerAndProducerForLock {

    private static final Lock lock = new ReentrantLock();

    private static final Condition full = lock.newCondition();

    private static final Condition empty = lock.newCondition();

    private static final Queue<Integer> queue = new ArrayDeque<>();

    private static Thread consumer;

    private static Thread producer;

    private static void consume() {
        consumer = new Thread(() -> {
            while (true) {
                lock.lock();
                if (queue.isEmpty()) {
                    try {
                        System.out.println("empty start await.");
                        empty.await();
                    } catch (InterruptedException e) {
                        lock.unlock();
                        break;
                    }
                } else {
                    Integer obj = queue.poll();
                    full.signal();
                    System.out.println("receive: " + obj);
                }
                lock.unlock();
            }
            System.out.println("consumer exit.");
        });
        consumer.start();
    }

    private static void produce() {
        producer = new Thread(() -> {
            while (true) {
                lock.lock();
                if (queue.size() > 10) {
                    try {
                        System.out.println("full start await.");
                        full.await();
                    } catch (InterruptedException e) {
                        System.out.println("producer exit.");
                        lock.unlock();
                        break;
                    }
                } else {
                    Integer obj = new Random().nextInt(10);
                    queue.offer(obj);
                    empty.signalAll();
                    System.out.println("send: " + obj);
                }
                lock.unlock();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
            }
            System.out.println("producer exit.");
        });
        producer.start();
    }

    public static void main(String[] args) throws InterruptedException {
        consume();
        produce();
        Thread.sleep(3000);
        consumer.interrupt();
        producer.interrupt();
    }
}
