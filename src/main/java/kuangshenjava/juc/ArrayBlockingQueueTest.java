package kuangshenjava.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        test1();
        test2();
        test3();
        test4();
    }

    /**
     * ArrayBlockingQueue
     * add和remove方法  抛异常
     */
    public static void test1() {
        //队列的大小
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));//输出true
        //超出容量，抛出异常java.lang.IllegalStateException: Queue full
        //System.out.println(blockingQueue.add("d"));

        System.out.println("=================");

        System.out.println(blockingQueue.remove());//输出a
        System.out.println(blockingQueue.remove());//输出b
        System.out.println(blockingQueue.remove());//输出c
        //抛出异常java.util.NoSuchElementException
        //System.out.println(blockingQueue.remove());
    }

    /**
     * ArrayBlockingQueue
     * offer和poll方法 有返回值，没有异常
     */
    public static void test2() {
        //队列的大小
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));//输出true
        System.out.println(blockingQueue.offer("d"));//没有异常，输出false

        System.out.println("=================");

        System.out.println(blockingQueue.poll());//输出a
        System.out.println(blockingQueue.poll());//输出b
        System.out.println(blockingQueue.poll());//输出c
        System.out.println(blockingQueue.poll());//没有异常，输出null
    }

    /**
     * ArrayBlockingQueue
     * put和take方法 等待，阻塞
     */
    public static void test3() throws InterruptedException {
        //队列的大小
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
//        blockingQueue.put("d");//队列没有位置了，一直阻塞

        System.out.println("=================");

        System.out.println(blockingQueue.take());//输出a
        System.out.println(blockingQueue.take());//输出b
        System.out.println(blockingQueue.take());//输出c
//        System.out.println(blockingQueue.take());//没有这个元素，一直阻塞
    }

    /**
     * ArrayBlockingQueue
     * offer和poll方法 等待，阻塞(等待超时)
     */
    public static void test4() throws InterruptedException {
        //队列的大小
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        blockingQueue.offer("d", 2, TimeUnit.SECONDS);//等待超过两秒就退出

        System.out.println("=================");

        System.out.println(blockingQueue.poll());//输出a
        System.out.println(blockingQueue.poll());//输出b
        System.out.println(blockingQueue.poll());//输出c
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));//等待超过两秒就退出
    }
}
