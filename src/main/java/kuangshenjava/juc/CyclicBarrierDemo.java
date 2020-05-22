package kuangshenjava.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 加法计数器
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier c = new CyclicBarrier(7, () -> System.out.println("计数器到7"));
        for (int i = 0; i < 7; i++) {
            //lambda表达式里面只能是final变量
            final int temp = i + 1;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 收集了" + temp + "颗龙珠");

                try {
                    c.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }
}
