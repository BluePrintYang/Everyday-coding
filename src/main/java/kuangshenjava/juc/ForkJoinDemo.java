package kuangshenjava.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @Author yangllong
 * @Date 2020/6/6 12:45
 */
public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test1();//745
//        test2();//3063
//        test3();//447
    }

    public static void test1() {
        long start = System.currentTimeMillis();
        long sum = 0;
        for (long i = 1; i <= 10_0000_0000L; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + " 时间" + (end - start));
    }

    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        long sum = 0;

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinTest(0L,10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        sum = submit.get();
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + " 时间" + (end - start));
    }

    public static void test3() {
        long start = System.currentTimeMillis();
        long sum = 0;
        sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + " 时间" + (end - start));
    }

    static class ForkJoinTest extends RecursiveTask<Long> {

        private Long start;
        private Long end;

        private Long temp = 10000L;

        public ForkJoinTest(Long start, Long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if ((end - start) < temp) {
                long sum = 0L;
                for (Long i = start; i <= end; i++) {
                    sum += i;
                }
                return sum;
            } else {
                long middle = (start + end) / 2;
                ForkJoinTest task1 = new ForkJoinTest(start, middle);
                task1.fork();
                ForkJoinTest task2 = new ForkJoinTest(middle, end);
                task2.fork();
                return task1.join() + task2.join();
            }
        }
    }
}
