package kuangshenjava.juc;


public class TestSingle {
    public static void main(String[] args) {
        double a = 3;
        float b = 3f;
        byte c = 3;
        int d = 3;
        System.out.println(0.3);
        System.out.println(a);
        System.out.println(b);
        System.out.println(b == a);
        System.out.println(b == 0.3);
        System.out.println(a == 0.3);
        System.out.println(c == d);
        System.out.println(b==3);

    }

}

class Single {
    private static Single instance = new Single();

    private Single() {
        System.out.println("1个Single对象实例化了");
    }

    public static Single getInstance() {
        return instance;
    }
}
