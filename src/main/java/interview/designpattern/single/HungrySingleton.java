package interview.designpattern.single;

/**
 * 饿汉单例模式
 * 空间换时间，线程安全
 */
public class HungrySingleton {
    private static HungrySingleton uniqueInstance = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return uniqueInstance;
    }
}
