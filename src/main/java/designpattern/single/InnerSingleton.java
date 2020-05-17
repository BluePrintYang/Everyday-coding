package designpattern.single;

/**
 * 很简单的实现线程安全，可以采用静态初始化器的方式，它可以由JVM来保证线程安全性.
 * <br>
 * 让类装载的时候不去初始化对象,
 * 一种可行的方式就是采用类级内部类，在这个类级内部类里面去创建对象实例，
 * 这样一来，只要不使用到这个类级内部类，那就不会创建对象实例。
 * 从而同时实现延迟加载和线程安全。
 */
public class InnerSingleton {
    private static class Singleton {
        private static InnerSingleton instance = new InnerSingleton();
    }

    private InnerSingleton() {
    }

    public static InnerSingleton getInstance() {
        return Singleton.instance;
    }
}
