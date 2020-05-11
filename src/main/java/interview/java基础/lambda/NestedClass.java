package interview.java基础.lambda;

/**
 * 嵌套类（nested class），指定义在另一个类内部的类。目的是只为它外部的类服务。
 * 有四种：
 * 1.静态成员类（static member class）
 * 2.非静态成员类（nonstatic member class）
 * 3.匿名类（anonymous class）
 * 4.局部类（local class）
 * 后三种都称为内部类（inner class）
 */
public class NestedClass {

    //外部类成员变量
    private static int nestedClassPrivateStaticVar;
    public int nestedClassPublicVar;
    protected int nestedClassProtectedVar;

    /**
     * 外部类的静态方法
     *
     * @param args String数组
     */
    public static void main(String[] args) {
        //通过类名调用静态内部类的静态方法
        StaticMemberClass.getNestedClassPrivateStaticVar();
        //通过类名访问静态内部类的静态成员
        System.out.println("外部类通过类名访问静态内部类的静态成员："+StaticMemberClass.staticPrivateValue);



        int x = 1;
        /*
        匿名内部类。不能是抽象类
        最常用创建方式：创建某个接口类型的对象
         */
        A a = new A() {
            @Override
            public void test() {
                System.out.println("匿名内部类方法的实现");
                //被匿名内部类访问的变量x无法再次赋值
                System.out.println(x);
            }
        };
       /* 转为lambda表达式
       A a = () -> {
            System.out.println("匿名内部类方法的实现");
            //被匿名内部类访问的变量x无法再次赋值
            System.out.println(x);
        };*/
        a.test();
        a.sayHello();
        A.test2();
    }


    /**
     * 外部类非静态方法
     */
    void print() {
        //可通过类名访问静态内部类的静态成员变量
        System.out.println("通过外部类非静态方法访问静态内部类的静态成员变量："+StaticMemberClass.staticPrivateValue);

        /*
          4.局部内部类，定义在外部类的方法中。非常鸡肋，很少使用，作用域太小，只能在方法内使用
          不能使用static修饰，没有意义
         */
        class LocalClass {

        }
    }

    /**
     * 1.静态成员类StaticMemberClass
     * ★★★属于整个类，不属于单个对象
     */
    static class StaticMemberClass {

        //外部类可通过类名访问
        private static int staticPrivateValue;
        //外部类无法访问
        public int staticValue;

        static void getNestedClassPrivateStaticVar() {
            //可访问外部类的静态成员变量
            nestedClassPrivateStaticVar = 0;
            System.out.println("通过静态内部类访问外部类的静态成员变量：" + nestedClassPrivateStaticVar);
        }
    }

    /**
     * 2.非静态内部类NonstaticMemberClass
     * 可访问外部类成员，但外部类不能访问非静态内部类的成员
     */
    class NonstaticMemberClass {

        //外部类不能访问非静态内部类的private成员变量
        private int nonStaticPrivateValue;
        //public成员变量外部类也不能访问
        public int nonStaticValue;

        //可访问外部类的所有成员，包括private
        void getNestedClassVar() {
            System.out.println("通过非静态内部类访问外部类的成员变量：");
            System.out.println("private static 成员变量：" + nestedClassPrivateStaticVar);
            System.out.println("public成员变量" + nestedClassPublicVar);
            System.out.println("protected成员变量" + nestedClassProtectedVar);
        }
    }
}
