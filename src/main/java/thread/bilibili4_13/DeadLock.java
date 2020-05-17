package thread.bilibili4_13;

/**
 * 死锁
 */
public class DeadLock {
    public static void main(String[] args) {

        Runnable r1 = ()->{
            synchronized ("A"){
                System.out.println("线程1获取了锁A，等待锁B");
                synchronized ("B"){
                    System.out.println("线程1同时获取A和B");
                }
            }
        };

        Runnable r2 = ()->{
            synchronized ("B"){
                System.out.println("线程2获取了锁B，等待锁A");
                synchronized ("A"){
                    System.out.println("线程2同时获取A和B");
                }
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}
