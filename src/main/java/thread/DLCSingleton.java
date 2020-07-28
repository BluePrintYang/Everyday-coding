package thread;

/**
 * @Author: yangllong
 * @DATE: 2020/7/24 10:12
 */
public class DLCSingleton {
    private static  DLCSingleton instance;
    private DLCSingleton(){}
    public static DLCSingleton getInstance(){
        if (instance==null){
            synchronized (DLCSingleton.class){
                if (instance==null)return new DLCSingleton();
            }
        }
        return instance;
    }
}
