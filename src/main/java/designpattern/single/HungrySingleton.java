package designpattern.single;

/**
 * 饿汉单例模式
 * 空间换时间，线程安全
 */
public class HungrySingleton {
    private static HungrySingleton uniqueInstance = new HungrySingleton();

    private HungrySingleton(){
        System.out.println("1个HungrySingleton类被实例化了");
    }

    public static HungrySingleton getInstance(){
        return uniqueInstance;
    }

    public static void main(String[] args) {
        Runnable r = HungrySingleton::getInstance;
        for (int i = 0; i < 100; i++) {
            new Thread(r).start();
        }
    }
}
