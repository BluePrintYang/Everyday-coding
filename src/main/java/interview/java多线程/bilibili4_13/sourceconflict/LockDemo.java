package interview.java多线程.bilibili4_13.sourceconflict;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {

        //实例化一个锁对象
        ReentrantLock lock = new ReentrantLock();

        Runnable r = () -> {
            while (TicketCenter.restTicket > 0) {
                lock.lock();
                if (TicketCenter.restTicket <= 0) return;
                System.out.println(Thread.currentThread().getName() + "卖出一张票，剩余" + --TicketCenter.restTicket + "张票");
                lock.unlock();
            }
        };

        Thread t1 = new Thread(r, "Thread1");
        Thread t2 = new Thread(r, "Thread2");
        Thread t3 = new Thread(r, "Thread3");
        Thread t4 = new Thread(r, "Thread4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

