package interview.java多线程.bilibili4_13;

public class TreadPriority {
    public static void main(String[] args) {
//        threadPriority();
    threadYield();
    }

    /**
     * 设置线程的优先级
     */
    private static void threadPriority() {

        //只是修改线程抢到cpu时间片的概率
        //并不一定优先级高就能抢到
        //优先级是个整数 [1,10] 默认5 ，最高10
        Runnable r = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        };

        Thread t1 = new Thread(r, "Thread1");
        Thread t2 = new Thread(r, "Thread2");


        //设置优先级,必须在start方法之前设置
        t1.setPriority(10);
        t2.setPriority(1);

        t1.start();
        t2.start();
    }

    /**
     * 线程的礼让
     * 放弃cpu时间片，然后重新抢夺，也可能还是抢到
     */
    private static void threadYield(){
        Runnable r = () ->{
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+":"+i);
                if (i==3)Thread.yield();
            }
        };

        Thread t1 = new Thread(r,"Thread1");
        Thread t2 = new Thread(r,"Thread2");

        t1.start();
        t2.start();
    }
}
