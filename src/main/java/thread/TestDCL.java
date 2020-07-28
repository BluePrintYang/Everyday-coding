package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: yangllong
 * @DATE: 2020/7/24 10:23
 */
public class TestDCL {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int count = 0;
        boolean flag =false;
        while (!flag) {
            FutureTask f1 = new FutureTask<>(DLCSingleton::getInstance);
            FutureTask f2 = new FutureTask<>(DLCSingleton::getInstance);
            Thread t1 = new Thread(f1);
            Thread t2 = new Thread(f2);
//            Thread.sleep(2000);
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            DLCSingleton single1 = (DLCSingleton) f1.get();
            DLCSingleton single2 = (DLCSingleton) f2.get();
            flag = (single1==single2);
            count++;
            System.out.println("time" + count);
        }
        System.out.println(count);
//        System.out.println(single==single1);
    }
}
