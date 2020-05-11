package interview.java多线程;

public class DecRunnable implements Runnable {

    MyData data;
    public DecRunnable(MyData data){
        this.data=data;
    }

    @Override
    public void run() {
        data.dec();
    }
}
