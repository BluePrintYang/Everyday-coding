package interview.java多线程;


public class MyThread2 extends MyThread implements Runnable {
    public void run(){
        System.out.println("MyThread2.run()");
    }

    public static void main(String[] args) {
        /*
        启动MyThread2，需要首先实例化一个Thread，并传入自己的MyThread实例
         */
        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);
        thread.start();
        /*
        事实上，当传入一个Runnable target参数给Thread后，Thread的run()方法就会调用target.run()
         */

    }
}
