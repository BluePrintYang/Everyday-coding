package foundation;

/**
 * @Author yangllong
 * @Date 2020/6/11 9:37
 */
public class Foo implements IFoo {
    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.bar(42);//此处调用的是接口中的default方法

        IFoo iFoo = foo;
        iFoo.bar(42);
    }

    public void bar(long l){
        System.out.println("Class function bar(long)");
    }
}
