package kuangshenjava.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    s.acquire();
                    System.out.println("抢到车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    s.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
