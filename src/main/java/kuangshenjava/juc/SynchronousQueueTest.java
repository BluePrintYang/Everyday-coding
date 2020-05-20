package kuangshenjava.juc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 同步队列，没有容量
 * 进去一个元素，必须取出来，才能往里放一个元素
 * put take
 */
public class SynchronousQueueTest {
    public static void main(String[] args) {
        BlockingQueue<String> blockingDeque = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " put 1");
                blockingDeque.put("1");
                System.out.println(Thread.currentThread().getName() + " put 2");
                blockingDeque.put("2");
                System.out.println(Thread.currentThread().getName() + " put 3");
                blockingDeque.put("3");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " take " + blockingDeque.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " take " + blockingDeque.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " take " + blockingDeque.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T2").start();
    }
}
