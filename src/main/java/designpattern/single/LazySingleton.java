package designpattern.single;

/**
 * 懒汉式单例
 * 时间换空间，不加同步是线程不安全的
 */
public class LazySingleton {
    private static LazySingleton uniqueInstance = null;
    //私有构造方法
    private LazySingleton() {
    }
    public static synchronized LazySingleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new LazySingleton();
        }
        return uniqueInstance;
    }
}
