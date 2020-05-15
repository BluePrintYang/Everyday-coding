package interview.designpattern.single;

/**
 * 改进的懒汉式单例
 * 双重检查加锁
 *<p>
 * 这种实现方式既可使实现线程安全的创建实例，又不会对性能造成太大的影响，
 * 它只是在第一次创建实例的时候同步，以后就不需要同步了，从而加快运行速度
 * </p>
 * <P>
 * 由于volatile关键字可能会屏蔽掉虚拟机中一些必要的代码优化，所以运行效率并不是很高，
 * 因此一般建议，没有特别的需要，不要使用。
 * 也就是说，虽然可以使用双重加锁机制来实现线程安全的单例，
 * 但并不建议大量采用，根据情况来选用吧
 * </P>
 */
public class LazySingleton2 {
    //对示例变量添加volatile修饰
    private static volatile LazySingleton2 instance = null;
    //私有构造方法
    private LazySingleton2() {
    }
    public static LazySingleton2 getInstance() {
        //同步块
        synchronized (LazySingleton2.class) {
            if (instance == null) {
                instance = new LazySingleton2();
            }
            return instance;
        }
    }
}
