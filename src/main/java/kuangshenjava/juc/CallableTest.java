package kuangshenjava.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> c = ()->{
            System.out.println("call()");
            return "123";
        };
        FutureTask<String> f = new FutureTask<>(c);
        for (int i = 0; i < 30; i++) {
            new Thread(f).start();
        }
        System.out.println(f.get());
    }
}

class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("call()");
        return "getValue";
    }
}
