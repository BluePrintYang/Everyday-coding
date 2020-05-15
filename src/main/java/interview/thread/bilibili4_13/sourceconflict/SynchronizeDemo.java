package interview.thread.bilibili4_13.sourceconflict;

public class SynchronizeDemo {
    public static void main(String[] args) {

        Runnable r = () ->{
                while (TicketCenter.restTicket>0){
                    //同步代码段
                    //synchronized小括号里面可以是对象也可以是类
                    //但是必须保证所以线程看到的锁是同一个
                    synchronized (""){
                        if (TicketCenter.restTicket<=0)return;
                        System.out.println(Thread.currentThread().getName()+"卖出一张票，剩余"+--TicketCenter.restTicket+"张票");
                }
            }
        };

        Thread t1 = new Thread(r,"Thread1");
        Thread t2 = new Thread(r,"Thread2");
        Thread t3 = new Thread(r,"Thread3");
        Thread t4 = new Thread(r,"Thread4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

