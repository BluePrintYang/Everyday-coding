package interview.java多线程.bilibili4_13.productorAndConsumer;

/**
 * 生产者消费者
 */
public class Program {

    public static void main(String[] args) {
        //实例化一个产品池对象
        ProductPool pool = new ProductPool(15);
        //实例化一个生产者
        new Producer(pool).start();
        //实例化一个消费者
        new Consumer(pool).start();
    }
}
