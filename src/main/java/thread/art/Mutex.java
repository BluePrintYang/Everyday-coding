package thread.art;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author yangllong
 * @Date 2020/6/26 21:37
 * 自定义一个独占锁，参考书籍《Java并发编程的艺术》
 * 独占锁，在同一时刻只能有一个线程获取到锁，而其它获取锁的线程只能处于同步队列中等待，
 * 只有获取锁的线程释放了锁，后继的线程才能够获取锁。
 */
public class Mutex implements Lock {

    //静态内部类，自定义同步器
    private static class Sync extends AbstractQueuedSynchronizer {
        //是否处于占用状态
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        //当状态为0的时候获取锁
        public boolean tryAcquire(int acquires) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        //释放锁，将状态设置为0
        protected boolean tryRelease(int releases) {
            if (getState() == 0) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        //返回一个Condition，每个condition都包含了一个condition队列
        Condition newCondition() {
            return new ConditionObject();
        }
    }

    //仅需要将操作代理到Sync上即可
    private final Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }

    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    public void unlock() {
        sync.release(1);
    }

    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean isLocked() {
        return sync.isHeldExclusively();
    }

    public boolean hasQueuedThreads() {
        return sync.hasQueuedThreads();
    }

    static int a = 0;

    public static void main(String[] args) throws InterruptedException {
        Mutex m = new Mutex();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                m.lock();
                try {
                    for (int j = 0; j < 200; j++) {
                        a++;
                    }
                } finally {
                    m.unlock();
                }

            }).start();
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println(a);
    }


}
