package foundation.generic;

import java.util.List;

/**
 * 泛型类
 * @param <T>
 *     ★★ Object类是String类的父类，但是GenericClass<Object>不是GenericClass<String>的父类<br>
 *     可以使用类型通配符(?)来表示各种泛型类的父类，即GenericClass<?>是各种泛型类的父类<br>
 *
 *     设定类型通配符的上限<br>
 *     List<? extends GenericClass>表示所有GenericClass泛型List的父类，<br>
 *     ?代表一个未知类型，但这个类型一定是GenericClass的子类或它本身<br>
 *
 *     设定类型通配符的下限<br>
 *     List<? super GenericClass>表示<>内传入的类型必须是GenericClass类的父类或它本身，<br>
 *     ?代表一个未知类型，但这个类型一定是GenericClass的父类或它本身<br>
 */
public class GenericClass<T> {
    //使用T类型形参定义实例变量
    private T info;

    //不能声明T类型的静态变量，也不能在静态方法声明中使用类型形参
//    private static T s;

    public GenericClass() {
    }

    public GenericClass(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    void test(List<?> l){
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }

    public static void main(String[] args) {
        GenericClass<String> g = new GenericClass<>();
        g.setInfo("ss");
        System.out.println(g.info);

        GenericClass<Double> g2 = new GenericClass<>();
        g2.setInfo(3.2);
        System.out.println(g2.getInfo());

        //输出为true,即GenericClass<String>与GenericClass<Double>是同一种类型
        System.out.println(g.getClass()==g2.getClass());

    }
}
