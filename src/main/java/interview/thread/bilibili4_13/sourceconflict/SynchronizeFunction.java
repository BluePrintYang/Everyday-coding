package interview.thread.bilibili4_13.sourceconflict;

public class SynchronizeFunction {
    public static void main(String[] args) {

        Runnable r = SynchronizeFunction::sellTicket;

        Thread t1 = new Thread(r,"Thread1");
        Thread t2 = new Thread(r,"Thread2");
        Thread t3 = new Thread(r,"Thread3");
        Thread t4 = new Thread(r,"Thread4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    /**
     * 方法为静态，则同步锁为类.class
     * 非静态，同步锁为this
     */
    private synchronized static void sellTicket(){
        while (TicketCenter.restTicket>0){
            System.out.println(Thread.currentThread().getName()+"卖出一张票，剩余"+--TicketCenter.restTicket+"张票");
        }
    }
}

