package interview.java基础.reflection;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyReflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //获取Test类的Class对象
        Class aClass = Class.forName("interview.java基础.reflection.TestForReflection");
        Class myClass = TestForReflection.class;
        //获取Test类的所有方法信息
        Method[] methods = aClass.getDeclaredMethods();
        Method[] methods2 = myClass.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("通过forName获取的class" + m.toString());
        }
        for (Method m : methods2) {
            System.out.println("通过类.class获取的class" + m.toString());
        }

        //获取Test类的所有成员属性信息
        Field[] fields = aClass.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.toString());
        }

        //获取Test类的所有构造方法信息
        Constructor[] constructors = aClass.getDeclaredConstructors();
        for (Constructor c : constructors) {
            System.out.println(c.toString());
        }

      /* //获取Test类的Class对象
       Class aClass = Class.forName("interview.java基础.reflection.TestForReflection");
       //使用.newInstance方法创建对象
        TestForReflection t = (TestForReflection) aClass.newInstance();
        //获取构造器方法并创建对象
        Constructor c = aClass.getDeclaredConstructor(int.class);
        //创建对象并设置属性
        TestForReflection t1 = (TestForReflection) c.newInstance(10);*/
    }

}
