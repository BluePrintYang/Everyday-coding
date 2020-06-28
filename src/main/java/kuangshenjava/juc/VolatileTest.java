package kuangshenjava.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author yangllong
 * @Date 2020/6/6 21:16
 * 测试volatile的变量可见性
 */
public class VolatileTest {

    private volatile static AtomicInteger a = new AtomicInteger(0);
    private final static int b = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    a.getAndIncrement();
                }
            }).start();
        }


        Thread.sleep(1000);

        System.out.println(a);
    }
}
