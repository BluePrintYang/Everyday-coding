package interview.thread.bilibili4_13;

/**
 * 线程的创建方式
 * 1.继承Thread类 简洁明了，但不可继承其他类
 * 2.实现Runnable接口
 */
public class ThreadTest {
    public static void main(String[] args) {

        //1.继承Thread类
        Thread1 thread = new Thread1();
        thread.start();

        //2.实现Runnable接口
        Runnable r = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("子线程2的run方法" + i);
            }
        };

        //实例化线程
        Thread t2 = new Thread(r);
        t2.start();

        System.out.println("主线程启动了");
    }
}

class Thread1 extends Thread {

    //重写run方法
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程1的run方法" + i);
        }
    }
}
