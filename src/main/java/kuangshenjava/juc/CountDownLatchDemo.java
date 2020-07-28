package kuangshenjava.juc;

import java.util.concurrent.CountDownLatch;

/**
 * 减计数器
 * 主要方法
 * countDown()//数量-1
 * await()//等待归零再执行下面的任务
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch c = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " Go Out");
                c.countDown();
            }, String.valueOf(i+1)).start();
        }
//        等计数器为0后再执行下面的任务
        c.await();
        System.out.println("Close Door");
    }

}
