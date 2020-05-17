package foundation.lambda;

/**
 * 测试匿名内部类的接口
 */
public interface A {
    //接口里定义的方法只能是public的抽象方法
    void test();
    //Java8之后，接口允许有默认方法，需要用default修饰。不能直接由接口调用
    default void sayHello(){
        System.out.println("Hello World!");
    }
    //可直接由接口调用的类方法，用static修饰
    static void test2(){
        System.out.println("接口里的类方法");
    }

}
