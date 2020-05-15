package interview.thread;

public class AddRunnable implements Runnable{

    MyData data;
    public AddRunnable(MyData data){
        this.data=data;
    }
    @Override
    public void run() {
        data.add();
    }
}
