package interview.foundation.generic;

/**
 * 需要为泛型传入实参
 * 如果不传入，编译器可能会发出警告
 */
public class GenericSonClass extends GenericClass<String> {
    //重新父类方法
    @Override
    public String getInfo() {
        return "子类"+super.getInfo();
    }

    public static void main(String[] args) {
        GenericSonClass s = new GenericSonClass();
        System.out.println(s.getInfo());
    }
}
