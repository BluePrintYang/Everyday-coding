package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private Lock lock = new ReentrantLock();
//    Lock lock = new ReentrantLock(true);//公平锁
//    Lock lock = new ReentrantLock(false);//非公平锁
    public Condition condition = lock.newCondition();//创建Condition
    public void testMethod(){
        try{
            lock.lock();//lock加锁
            //1:wait方法等待
            //System.out.println("开始wait");
            condition.await();
            //通过创建Condition对象来使线程wait，必须先执行lock.lock方法来获得锁
            //2:signal方法唤醒
            condition.signal();//condition对象的signal方法可以唤醒wait线程
            for (int i = 0; i<5;i++){
                System.out.println("ThreadName="+Thread.currentThread().getName()+(" "+(i+1)));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
}
