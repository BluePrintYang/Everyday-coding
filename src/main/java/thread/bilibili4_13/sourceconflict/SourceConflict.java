package thread.bilibili4_13.sourceconflict;

public class SourceConflict {
    public static void main(String[] args) {

        Runnable r = () ->{
            while (TicketCenter.restTicket>0){
                System.out.println(Thread.currentThread().getName()+"卖出一张票，剩余"+--TicketCenter.restTicket+"张票");
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

class TicketCenter{
    public static int restTicket=100;
}