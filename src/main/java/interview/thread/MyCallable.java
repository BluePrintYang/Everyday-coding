package interview.thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {

    private String oid;

    public MyCallable(String oid) {
        this.oid = oid;
    }

    @Override
    public Object call() throws Exception {
        return oid+"任务返回的内容";
    }
}
