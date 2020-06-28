package thread.art;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author yangllong
 * @Date 2020/6/11 16:13
 *
 * 并发编程的艺术书籍
 * 使用循环CAS实现原子操作
 */
public class Counter {
    private AtomicInteger atomicI = new AtomicInteger(0);
    private int i = 0;

    public static void main(String[] args) {
        final Counter cas = new Counter();
        List<Thread> ts = new ArrayList<>(600);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    cas.count();
                    cas.safeCount();
                }
            });
            ts.add(t);
        }
        for (Thread t:ts) {
            t.start();
        }

        for (Thread t :
                ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(cas.i);
        System.out.println(cas.atomicI.get());
        System.out.println(System.currentTimeMillis()-start);


    }

    //非线程安全计数器
    private void count() {
        i++;
    }

    //使用cas实现线程安全计数器
    private void safeCount() {
        for (;;){
            int i = atomicI.get();
            boolean suc = atomicI.compareAndSet(i,++i);
            if (suc){
                break;
            }
        }
    }


}
