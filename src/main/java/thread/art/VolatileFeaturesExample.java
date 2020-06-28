package thread.art;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author yangllong
 * @Date 2020/6/20 22:57
 */
public class VolatileFeaturesExample {
    static long v1 = 0L;

    public static void set(long l) {
        v1 = l;
    }

    public static synchronized void getAndIncrement() {
        v1++;
    }

    public static long get() {
        return v1;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, Runtime.getRuntime().availableProcessors(), 3, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0; i < 100; i++) {
            pool.execute(() -> {
                getAndIncrement();
            });
//            new Thread(VolatileFeaturesExample::getAndIncrement).start();
        }
        pool.shutdown();

        TimeUnit.SECONDS.sleep(1);

        System.out.println(v1);
    }
}
