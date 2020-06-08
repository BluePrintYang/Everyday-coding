package kuangshenjava.juc;

import java.util.concurrent.*;

/**
 * 线程池：3大方法、7大参数、4种拒绝策略
 * 好处：1.降低资源消耗  2.提高响应速度  3.方便管理
 * 拒绝策略：
 * new ThreadPoolExecutor.AbortPolicy()// 银行满了，还有人进来，不处理这个人的，抛出异常
 * new ThreadPoolExecutor.CallerRunsPolicy() // 哪来的去哪里！
 * new ThreadPoolExecutor.DiscardPolicy() //队列满了，丢掉任务，不会抛出异常！
 * new ThreadPoolExecutor.DiscardOldestPolicy() //队列满了，尝试去和最早的竞争，也不会抛出异常！
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
//        executors();
//        createThreadPool();
        long a = 2147483647;
        int b = 2147483647;

    }

    /**
     * 使用Executors工具类创建线程池 3大方法
     * 本质ThreadPoolExecutor()
     */
    public static void executors() {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();//单个线程
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);//固定线程池大小
//        ExecutorService threadPool = Executors.newCachedThreadPool();//可伸缩
//        ExecutorService threadPool = Executors.newScheduledThreadPool(5);
        try {
            for (int i = 0; i < 100; i++) {
                //使用线程池创建线程
                threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + " OK"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //线程池用完，程序结束，关闭线程池
            threadPool.shutdown();
        }
    }


    /**
     * 自定义线程池
     * 池的最大的大小如何去设置！
     * 了解：IO密集型，CPU密集型：（调优）
     * IO密集型：判断程序中十分耗IO的线程
     * CPU密集型：几核，就是几，可以保持CPU效率最高
     *
     * 最大线程到底该如何定义
     * 1、CPU 密集型，几核，就是几，可以保持CPU的效率最高！
     * 2、IO  密集型   > 判断你程序中十分耗IO的线程，
     * 程序   15个大型任务(2*15个线程)  io十分占用资源！
     */
    public static void createThreadPool() {
        System.out.println("CPU核数："+Runtime.getRuntime().availableProcessors());
        //自定义线程池
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,//核心线程池大小
                Runtime.getRuntime().availableProcessors(),//最大核心线程池大小,这里选取cpu核数
                3,//超时了没有人调用就会释放
                TimeUnit.SECONDS,//超时单位
                new LinkedBlockingQueue<>(3),//阻塞队列
                Executors.defaultThreadFactory(),//线程工厂：创建线程的，一般不用动
                new ThreadPoolExecutor.DiscardPolicy()// 银行满了，还有人进来，不处理这个人的，抛出异常
        );

        try {
            for (int i = 0; i < 30; i++) {
                threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + " OK"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //线程池用完，程序结束，关闭线程池
            threadPool.shutdown();
        }
    }


}
